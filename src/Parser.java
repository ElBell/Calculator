public class Parser {
    public Parser() {

    }
    public Calculations parse(String rawInput){
        String[] brokenInput = breakIntoArray(rawInput);
        String[] sortedInput = sortByOperation(brokenInput);
        //Calculation calculationTree = parseCalculations(sortedInput);
        return null;//calculationTree;
    }

    public String[] breakIntoArray(String toBreak){
        String[] broken = toBreak.split("[-+*/()]");
        for (String split: broken) {
            System.out.println(split);
        }
        return null;
    }

    public String[] sortByOperation(String[] sortedBroken){
        //Djikstra's Shunting Yard
        return null;
    }
}
