public interface IController {
    public void onGasActivated();

    public void onBrakeActivated();

    public void onStartActivated();

    public void onStopActivated();

    public void onSetTurboOnActivated();

    public void onSetTurboOffActivated();

    public void onLowerBedActivated();

    public void onLiftBedActivated();

    public void onSpinnerChange(int i);
}
