package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController controller;
    TrainSensor sensor;
    TrainUser user;

    @Before
    public void before() {
        controller= mock(TrainController.class);
        user= mock(TrainUser.class);
        sensor =  new TrainSensorImpl(controller,user);
    }

    @Test
    public void alarmTooMuchSpeed() {
        sensor.overrideSpeedLimit(501);

        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void alarmMinusSpeed() {
        sensor.overrideSpeedLimit(-1);

        verify(user, times(1)).setAlarmState(true);
    }
    @Test
    public void noAlarmAtNormalSpeed() {
        sensor.overrideSpeedLimit(500);

        verify(user, never()).setAlarmState(true);
    }
    @Test
    public void NoAlarmAtNormalSpeed() {
        when(controller.getReferenceSpeed()).thenReturn(202);
        sensor.overrideSpeedLimit(100);

        verify(user, times(1)).setAlarmState(true);
    }




}
