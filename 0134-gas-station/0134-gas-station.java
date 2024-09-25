class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasSoFar = 0;
        int totalGasCurrentIndex = 0;
        int circuitIndex = 0;

        for(int i = 0; i < gas.length; i++) {
            totalGasSoFar += gas[i] - cost[i];
            totalGasCurrentIndex += gas[i] - cost[i];

            if(totalGasCurrentIndex <0) {
                totalGasCurrentIndex = 0;
                circuitIndex = i + 1;
            }
        }
        return totalGasSoFar >= 0 ? circuitIndex : -1;
    }
}