class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> folders = new ArrayList<>();
        List<String> listFolder = new ArrayList<>(Arrays.asList(folder));

        Collections.sort(listFolder);
                     
        for (int i = 0; i < listFolder.size(); i++) {
            String f = listFolder.get(i);
            folders.add(f);

            for (int j = i + 1; j < listFolder.size(); j++) {
                String t = listFolder.get(j);
                if (t.startsWith(f + "/")) {
                    i++;
                } else {
                    break;
                }
            }
        }

        return folders;
    }
}