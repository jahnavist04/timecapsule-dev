
package dev.timecapsule;

import java.time.LocalDateTime;
import java.util.List;

public class Snapshot {

    private String projectName;
    private String projectPath;
    private String gitBranch;
    private List<String> modifiedFiles;
    private String developerNotes;
    private LocalDateTime timestamp;

    public Snapshot(String projectName, String projectPath,
                    String gitBranch, List<String> modifiedFiles,
                    String developerNotes) {

        this.projectName = projectName;
        this.projectPath = projectPath;
        this.gitBranch = gitBranch;
        this.modifiedFiles = modifiedFiles;
        this.developerNotes = developerNotes;
        this.timestamp = LocalDateTime.now();
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public String getGitBranch() {
        return gitBranch;
    }

    public List<String> getModifiedFiles() {
        return modifiedFiles;
    }

    public String getDeveloperNotes() {
        return developerNotes;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
