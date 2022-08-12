package inf.puc.rio.br.opus.database.smells;

import com.fasterxml.jackson.databind.ObjectMapper;
import inf.puc.rio.br.opus.database.composites.CompositeRepository;
import inf.puc.rio.br.opus.model.compositeref.CompositeRefactoring;
import inf.puc.rio.br.opus.model.smell.CodeSmell;
import inf.puc.rio.br.opus.model.smell.organic.OuputOrganic;
import inf.puc.rio.br.opus.parser.smell.SmellParser;
import inf.puc.rio.br.opus.utils.AnalysisUtils;
import inf.puc.rio.br.opus.utils.CompositeUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmellCollector {

    private SmellRepository smellRepository;
    private CompositeRepository compositeRepository;

    private SmellCollector(String[] args){
        smellRepository = new SmellRepository(args);
        compositeRepository = new CompositeRepository(args);
    }

    public SmellCollector(){

    }

    public static void main(String[] args) {
        SmellCollector collector = new SmellCollector(args);
        List<CodeSmell> smells = collector.getSmellsByComposites("hystrix", "composites\\hystrix-composite-rangebased.json");
        collector.smellRepository.insertAllSmells(smells);
    }

    private List<CodeSmell> getSmellsByComposites(String projectName, String pathComposite){

        ObjectMapper mapper = new ObjectMapper();
        try {
            CompositeRefactoring[] compositeMapper = mapper.readValue(new File(pathComposite), CompositeRefactoring[].class);
            List<CompositeRefactoring> composites = new ArrayList<>(Arrays.asList(compositeMapper));
            List<String> commitsOfComposites = CompositeUtils.getCommitsOfCompositesByProject(composites);
            List<String> smellFiles = new ArrayList<>();
            for (String commit : commitsOfComposites) {

                String smellFile = "C:\\Users\\anaca\\OneDrive\\PUC-Rio\\OPUS\\CompositeRefactoring\\Dataset\\Smells\\output-" + projectName + "\\" + commit + ".json";
                smellFiles.add(smellFile);
            }
            return getAllSmells(projectName, smellFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<CodeSmell> getSmellsByComposites(String projectName){

        List<CompositeRefactoring> composites = compositeRepository.getCompositesByProject(projectName);
        List<String> commitsOfComposites = CompositeUtils.getCommitsOfCompositesByProject(composites);
        List<String> smellFiles = new ArrayList<>();
        for (String commit : commitsOfComposites) {

            String smellFile = "C:\\Users\\anaca\\OneDrive\\PUC-Rio\\OPUS\\CompositeRefactoring\\Dataset\\Smells\\output-" + projectName + "\\" + commit + ".json";
            smellFiles.add(smellFile);
        }
        return getAllSmells(projectName, smellFiles);
    }

    private List<CodeSmell> getAllSmells(String projectName, List<String> smellFiles){
        ObjectMapper mapper = new ObjectMapper();
        OuputOrganic[] smells = new OuputOrganic[0];
        String extensionName = ".json";
        SmellParser parser = new SmellParser();
        List<CodeSmell> smellsOurModel = new ArrayList<>();
        try {
            for (String smellFile : smellFiles) {
                System.out.println(smellFile);
                String commit = AnalysisUtils.getOnlyFileNameFromPath(smellFile, extensionName);
                System.out.println(commit);
                smells = mapper.readValue(new File(smellFile), OuputOrganic[].class);
                List<OuputOrganic> smellOutputOrganic = new ArrayList<>(Arrays.asList(smells));
                List<CodeSmell> smellsAuxOurModel = parser.parserOrganicSmellToOurSmellModel(smellOutputOrganic, projectName, commit);
                smellsOurModel.addAll(smellsAuxOurModel);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return smellsOurModel;
    }

    public List<CodeSmell> getAllSmells(String projectName, String pathOutput){
        ObjectMapper mapper = new ObjectMapper();
        OuputOrganic[] smells = new OuputOrganic[0];
        String extensionName = ".json";
        List<String> smellFiles = AnalysisUtils.getAllFileNames(pathOutput, extensionName);
        SmellParser parser = new SmellParser();
        List<CodeSmell> smellsOurModel = new ArrayList<>();
        try {
            for (String smellFile : smellFiles) {
                System.out.println(smellFile);
                String commit = AnalysisUtils.getOnlyFileNameFromPath(smellFile, extensionName);
                System.out.println(commit);
                smells = mapper.readValue(new File(smellFile), OuputOrganic[].class);
                List<OuputOrganic> smellOutputOrganic = new ArrayList<>(Arrays.asList(smells));
                List<CodeSmell> smellsAuxOurModel = parser.parserOrganicSmellToOurSmellModel(smellOutputOrganic, projectName, commit);
                smellsOurModel.addAll(smellsAuxOurModel);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return smellsOurModel;
    }
}
