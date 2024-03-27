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
