class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> folders = new ArrayList<>();
        Arrays.sort(folder);

        String prevFolder = folder[0];
        folders.add(prevFolder);
        for (int i = 1; i < folder.length; i++) {
            String f = folder[i];
            if (!f.startsWith(prevFolder + "/")) {
                folders.add(f);
                prevFolder = f;
            }
        }
        return folders;
    }
}