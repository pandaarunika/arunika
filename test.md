  List<DataEntry> entries = new ArrayList<>();
        for (Map.Entry<String, Map<String, Object>> outerEntry : data.entrySet()) {
            String outerKey = outerEntry.getKey();
            Map<String, Object> innerMap = outerEntry.getValue();
            for (Map.Entry<String, Object> innerEntry : innerMap.entrySet()) {
                String innerKey = innerEntry.getKey();
                Object innerValue = innerEntry.getValue();
                entries.add(new DataEntry(outerKey, innerKey, (MyObject) innerValue));
            }
        }


 static class DataEntry {
        private String sorKey;
        private String dateKey;
        private MyObject myObject;

        public DataEntry(String sorKey, String dateKey, MyObject myObject) {
            this.sorKey = sorKey;
            this.dateKey = dateKey;
            this.myObject = myObject;
        }

        // Getters and setters
        // ...
    }
