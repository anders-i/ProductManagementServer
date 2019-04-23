/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import io.swagger.model.Barcode;

/**
 *
 * @author As
 */
public class RandomNumber {

    public Barcode randomBarcode() {
        Barcode barcode = new Barcode();
        Long leftLimit = 1000000000000L;
        Long rightLimit = 9999999999999L;
        Long longRandom = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        barcode.setBarcodeID(longRandom);
 
        return barcode;
    }
        public Barcode randomLocationBarcode() {
        Barcode barcode = new Barcode();
        Long leftLimit  = 100000L;
        Long rightLimit = 999999L;
        Long longRandom = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        barcode.setBarcodeID(longRandom);
 
        return barcode;
    
    }
}
