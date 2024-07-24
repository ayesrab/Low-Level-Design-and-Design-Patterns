package AdapterDesignPattern.Adapter;

import AdapterDesignPattern.Adaptee.WeightMachine;

public class WeightMachingAdapterImpl implements WeightMachineAdapter{
    WeightMachine weightMachine;

    public WeightMachingAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {
        double weightInPound = weightMachine.getWeightInPounds();
        return weightInPound * 0.45359237;
    }
}
