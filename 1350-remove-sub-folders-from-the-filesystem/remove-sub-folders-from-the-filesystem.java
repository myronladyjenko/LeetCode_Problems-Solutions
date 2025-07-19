class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> folders = new ArrayList<>();
        List<String> listFolder = new ArrayList<>(Arrays.asList(folder));

        Collections.sort(listFolder);
        String prevFolder = listFolder.get(0);
        folders.add(prevFolder);
                     
        for (int i = 1; i < listFolder.size(); i++) {
            String f = listFolder.get(i);
            if (f.startsWith(prevFolder + "/")) {
                continue;
            }
            folders.add(f);
            prevFolder = f;

            // for (int j = i + 1; j < listFolder.size(); j++) {
            //     String t = listFolder.get(j);
            //     if (t.startsWith(f + "/")) {
            //         i++;
            //     } else {
            //         break;
            //     }
            // }
        }
        return folders;
    }
}