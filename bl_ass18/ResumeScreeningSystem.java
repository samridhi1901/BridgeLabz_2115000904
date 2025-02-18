import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract void evaluateResume();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluateResume() {
        System.out.println(getCandidateName() + " - Software Engineer: Evaluated on coding skills, algorithms, and system design.");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluateResume() {
        System.out.println(getCandidateName() + " - Data Scientist: Evaluated on data analysis, ML models, and statistical knowledge.");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluateResume() {
        System.out.println(getCandidateName() + " - Product Manager: Evaluated on business strategy, UX, and leadership skills.");
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void processResume() {
        jobRole.evaluateResume();
    }
}

class ResumeScreeningPipeline {
    private List<Resume<? extends JobRole>> resumeList = new ArrayList<>();

    public void addResume(Resume<? extends JobRole> resume) {
        resumeList.add(resume);
    }

    public void processAllResumes() {
        for (Resume<? extends JobRole> resume : resumeList) {
            resume.processResume();
            System.out.println("--------------------");
        }
    }

    public static <T extends JobRole> void validateAndProcessResume(T jobRole) {
        System.out.println("Validating Resume for: " + jobRole.getCandidateName());
        jobRole.evaluateResume();
        System.out.println("Resume successfully processed!\n");
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume1 = new Resume<>(new SoftwareEngineer("Alice"));
        Resume<DataScientist> resume2 = new Resume<>(new DataScientist("Bob"));
        Resume<ProductManager> resume3 = new Resume<>(new ProductManager("Charlie"));

        ResumeScreeningPipeline pipeline = new ResumeScreeningPipeline();
        pipeline.addResume(resume1);
        pipeline.addResume(resume2);
        pipeline.addResume(resume3);

        System.out.println("Processing Resumes in AI Screening Pipeline:");
        pipeline.processAllResumes();

        System.out.println("\nValidating and Processing New Resumes:");
        ResumeScreeningPipeline.validateAndProcessResume(new SoftwareEngineer("David"));
        ResumeScreeningPipeline.validateAndProcessResume(new DataScientist("Eve"));
    }
}
