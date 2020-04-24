package com.example.kentsimgeleri;

import android.graphics.Bitmap;

public class Singleton {

    private Bitmap secilmisResim;

    private static Singleton singleton;

    private Singleton(){

    }

    public Bitmap getSecilmisResim() {
        return secilmisResim;
    }

    public void setSecilmisResim(Bitmap secilmisResim) {
        this.secilmisResim = secilmisResim;
    }

    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
