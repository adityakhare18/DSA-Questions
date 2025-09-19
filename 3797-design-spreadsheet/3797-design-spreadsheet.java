class Spreadsheet {
    HashMap<String,Integer> map;

    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell,value);
    }
    
    public void resetCell(String cell) {
        map.put(cell,0);
    }
    
    public int getValue(String formula) {
        formula = formula.substring(1); // remove '='
        String[] parts = formula.split("\\+"); 
        
        String s1 = parts[0];
        String s2 = parts[1];

        int left = Character.isUpperCase(s1.charAt(0)) 
                    ? map.getOrDefault(s1, 0) 
                    : Integer.parseInt(s1);

        int right = Character.isUpperCase(s2.charAt(0)) 
                    ? map.getOrDefault(s2, 0) 
                    : Integer.parseInt(s2);

        return left + right;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */