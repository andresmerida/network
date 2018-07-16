package com.exercises.network;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class NetworkTest {
    private Network integerNetwork;
    private static final int NUMBER_OF_ELEMENTS = 8;

    @Before
    public void setUp() {
        integerNetwork = new Network(NUMBER_OF_ELEMENTS);

        integerNetwork.connect(1, 2);
        integerNetwork.connect(1, 6);
        integerNetwork.connect(6, 2);
        integerNetwork.connect(2, 4);
        integerNetwork.connect(5, 8);
    }

    @Test
    public void connectionsTest() {
        assertTrue(integerNetwork.query(1, 6));
        assertTrue(integerNetwork.query(6, 4));
        assertTrue(integerNetwork.query(5, 8));

        assertFalse(integerNetwork.query(7, 4));
        assertFalse(integerNetwork.query(5, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionQueryTest() {
        // only exist from 1 to 8
        integerNetwork.query(1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionConnectTest() {
        integerNetwork.connect(1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionInstanceTest() {
        new Network(-1);
    }
}
