
package dev.timecapsule;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GitService {

    private String projectPath;

    public GitService(String projectPath) {
        this.projectPath = projectPath;
    }

    private String executeGitCommand(String command) {

        try {
            Process process = new ProcessBuilder(
                    "git", command
            )
                    .directory(new java.io.File(projectPath))
                    .redirectErrorStream(true)
                    .start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String result = reader.readLine();

            process.waitFor();

            return result != null ? result : "No information found";

        } catch (Exception e) {
            return "Git information unavailable";
        }
    }

    public String getCurrentBranch() {
        return executeGitCommand("branch --show-current");
    }

    public List<String> getModifiedFiles() {

        List<String> files = new ArrayList<>();

        try {
            Process process = new ProcessBuilder(
                    "git", "status", "--short"
            )
                    .directory(new java.io.File(projectPath))
                    .redirectErrorStream(true)
                    .start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;

            while ((line = reader.readLine()) != null) {
                files.add(line);
            }

            process.waitFor();

        } catch (Exception e) {
            files.add("Unable to retrieve modified files");
        }

        return files;
    }
}
