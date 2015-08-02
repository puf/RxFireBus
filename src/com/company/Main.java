package com.company;

import com.firebase.client.*;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 *
 * The goal of this application is to detect public transport vehicles from which the drivers can see each
 * other, so that we can tell them to wave.
 *
 * This means that the vehicles must: around the same time, be within a certain distance from each other, and
 * be heading in the opposite direction.
 *
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Observable<Vehicle> vehicles = Observable.create(new Observable.OnSubscribe<Vehicle>() {
            @Override
            public void call(final Subscriber<? super Vehicle> subscriber) {
                Firebase ref = new Firebase("https://publicdata-transit.firebaseio.com/sf-muni/vehicles");
                //"dirTag":"60___I_F00","heading":171,"id":2,"lat":37.7854,"lon":-122.40756,"predictable":true,"routeTag":"60","secsSinceReport":2,"speedKmHr":0,"timestamp":1438366207486,"vtype":"bus"}
                ref.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot snapshot, String s) {
                        subscriber.onNext(snapshot.getValue(Vehicle.class));
                    }

                    @Override
                    public void onChildChanged(DataSnapshot snapshot, String s) {
                        subscriber.onNext(snapshot.getValue(Vehicle.class));
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot snapshot) {
                    }

                    @Override
                    public void onChildMoved(DataSnapshot snapshot, String s) {
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.err.println("onCancelled: "+firebaseError.toString());
                        subscriber.onCompleted(); // or onError?
                    }
                });
            }
        });
        vehicles.forEach(new Action1<Vehicle>() {
            @Override
            public void call(Vehicle vehicle) {
                System.out.println(vehicle.toString());
            }
        });

        Thread.sleep(30000);
    }
}
