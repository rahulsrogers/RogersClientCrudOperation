package com.chat.features.service;

import com.chat.features.model.*;
import com.chat.features.repository.RogersClientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class RogersClientService implements  RogersService {

    private RogersClientRepo rogersClientRepo;

    @Autowired
    public RogersClientService(RogersClientRepo rogersClientRepo) {
        this.rogersClientRepo = rogersClientRepo;
    }


    private FeatureDetails.BrandEnum convertToFeatureDetailsBrand(Brand brand) {
        if (brand == null) {
            return null;
        }
        switch (brand) {
            case Fido:
                return FeatureDetails.BrandEnum.FIDO;
            case Rogers:
                return FeatureDetails.BrandEnum.ROGERS;
            case Chatr:
                return FeatureDetails.BrandEnum.CHATR;
            default:
                return null;
        }
    }

    private Brand convertToFeatureDetailsBrand(FeatureRequest.BrandEnum brand) {
        if (brand == null) {
            return null;
        }
        switch (brand) {
            case ROGERS:
                return Brand.Rogers;
            case CHATR:
                return Brand.Chatr;
            case FIDO:
                return Brand.Fido;
            default:
                return null;
        }
    }


    private FeatureDetails.LaunchQuarterEnum convertToFeatureDetailsLaunchQuter(LaunchQuarter launchQuarter) {
        if (launchQuarter == null) {
            return null;
        }
        switch (launchQuarter) {
            case Q1:
                return FeatureDetails.LaunchQuarterEnum.Q1;
            case Q2:
                return FeatureDetails.LaunchQuarterEnum.Q2;
            case Q3:
                return FeatureDetails.LaunchQuarterEnum.Q3;
            case Q4:
                return FeatureDetails.LaunchQuarterEnum.Q4;
            default:
                return null;
        }

    }

    private LaunchQuarter convertToFeatureDetailsLaunchQuter(FeatureRequest.LaunchQuarterEnum launchQuarter_1) {
        if (launchQuarter_1 == null) {
            return null;
        }
        switch (launchQuarter_1) {
            case Q1:
                return LaunchQuarter.Q1;
            case Q2:
                return LaunchQuarter.Q2;
            case Q3:
                return LaunchQuarter.Q3;
            case Q4:
                return LaunchQuarter.Q4;
            default:
                return null;
        }

    }

    @Override
    public List<FeatureDetails> getTodos() {
        List<FeatureDetails> featureDetailsList = new ArrayList<>();
        List<RogersClientModel> models = rogersClientRepo.findAll();
        List reverseList = new ArrayList<>();
        ListIterator listIterator = null;

        models.forEach(model -> {
            Comparator<FeatureDetails> comparator = new Comparator<FeatureDetails>() {

                @Override
                public int compare(FeatureDetails o1, FeatureDetails o2) {
                    String launchDate_1 = o1.getLaunchDate();
                    String launchDate_2 = o2.getLaunchDate();
                    return launchDate_2.compareTo(launchDate_1);

                }
            };

            FeatureDetails featureDetails = new FeatureDetails();
            //String s=featureDetails.getLaunchDate();

            if (model.getIs_deleted() == false) {

                featureDetails.setTitle(model.getTitle());
                featureDetails.setId(model.getId());
                featureDetails.setLaunchYear(model.getLaunchYear());
                featureDetails.setExpectedRoi(model.getExpectedRoi());
                featureDetails.setLaunchDate(model.getLaunchDate());
                featureDetails.setDescription(model.getDescription());
                featureDetails.setBrand(convertToFeatureDetailsBrand(model.getBrand()));
                featureDetails.setProductOwner(model.getProductOwner());
                featureDetails.setLaunchQuarter(convertToFeatureDetailsLaunchQuter(model.getLaunchQuarter()));
                featureDetails.setBusinessValue(model.getBusinessValue());
                Collections.sort(featureDetailsList, comparator);
                featureDetailsList.add(featureDetails);
            }
        });
        return featureDetailsList;
    }

    public List<List<FeatureDetails>> getFeaturesGroupedByLaunchYear(List<FeatureDetails> featuresListToBeGrouped) {
        Map<Integer, List<FeatureDetails>> featuresByYear = new LinkedHashMap<>();
        featuresByYear = featuresListToBeGrouped.stream().collect(Collectors.groupingBy(FeatureDetails :: getLaunchYear));
        return featuresByYear.values().stream().collect(Collectors.toCollection(ArrayList :: new));
    }


    public List<List<FeatureDetails>> getTodos(String fromDate, String toDate, String groupBy) {
        log.info("getTodos method calls ");
        if ((fromDate == null && toDate != null) || (fromDate != null && toDate == null)) {
            // TODO: throw exception
        }

        List<List<FeatureDetails>> oflist = new ArrayList<>();
        List<FeatureDetails> featureDetailsList = new ArrayList<>();
        if (fromDate != null && toDate != null) {
            // filter featuresList based on fromDate and toDate
            featureDetailsList = filterBasedOnDates(fromDate, toDate, getFeatureDetails());
        } else {
            featureDetailsList =  getFeatureDetails();
            log.info("gotodo method calls to getFeatures ");
        }
        if (groupBy != null) {
            if (groupBy.equals("y")) {
                return getFeaturesGroupedByLaunchYear(featureDetailsList);
            } else if (groupBy.equals("q")) {
                // TODO: return the list of features grouped by year and quarter
            } else {
                // TODO: return the list of features grouped by day
            }
        }
        oflist.add(featureDetailsList);
        return oflist;
    }


    private List<FeatureDetails> filterBasedOnDates(String fromDate, String toDate, List<FeatureDetails> featureDetailsList) {
        List<FeatureDetails> filteredList = new ArrayList<>();
        log.info("filterBasedonDates method calls ");



        featureDetailsList.forEach(featureDetails -> {
            try {
                Date from_date = new SimpleDateFormat("yyyy/MM/dd ", Locale.ENGLISH)
                        .parse(fromDate);
                Date to_date = new SimpleDateFormat("yyyy/MM/dd ", Locale.ENGLISH)
                        .parse(toDate);
                Date launc_date = new SimpleDateFormat("yyyy/MM/dd ", Locale.ENGLISH)
                        .parse(featureDetails.getLaunchDate());

                System.out.println(from_date);
                System.out.println(to_date);

                if (to_date.compareTo(launc_date)>=0 && from_date.compareTo(launc_date)<=0 ) {
                   // System.out.println("start is after end");
                    filteredList.add(featureDetails);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }



        });
        return filteredList;
    }



    private List<FeatureDetails> getFeatureDetails( ) {

        log.info("getfeaturesDeatils method calls ");
        List<FeatureDetails> featureDetailsList = new ArrayList<>();
        List<RogersClientModel> models = new ArrayList<>();

            models = rogersClientRepo.findAll();
        System.out.println(models.size());
        log.info("Find All method calls "+models.size());

        models.forEach(model -> {
            Comparator<FeatureDetails> comparator = new Comparator<FeatureDetails>() {

                @Override
                public int compare(FeatureDetails o1, FeatureDetails o2) {
                    String launchDate_1 = o1.getLaunchDate();
                    String launchDate_2 = o2.getLaunchDate();
                    log.info("Comparator calls for launch_date descending order");
                    return launchDate_2.compareTo(launchDate_1);

                }};

            FeatureDetails featureDetails = new FeatureDetails();
            //String s=featureDetails.getLaunchDate();

            if (model.getIs_deleted()==false){

                featureDetails.setTitle(model.getTitle());
                featureDetails.setId(model.getId());
                featureDetails.setLaunchYear(model.getLaunchYear());
                featureDetails.setExpectedRoi(model.getExpectedRoi());
                featureDetails.setLaunchDate(model.getLaunchDate());
                featureDetails.setDescription(model.getDescription());
                featureDetails.setBrand(convertToFeatureDetailsBrand(model.getBrand()));
                featureDetails.setProductOwner(model.getProductOwner());
                featureDetails.setLaunchQuarter(convertToFeatureDetailsLaunchQuter(model.getLaunchQuarter()));
                featureDetails.setBusinessValue(model.getBusinessValue());

                featureDetailsList.add(featureDetails);
                Collections.sort(featureDetailsList,comparator);
                log.info("FeatureList size iteartor "+featureDetailsList.size());

            }});
        return featureDetailsList;
    }


    public FeatureDetails getTodoById(String id) {
FeatureDetails s=new FeatureDetails();
RogersClientModel model=rogersClientRepo.findByid(id);
s.setId(model.getId());
s.setBrand(convertToFeatureDetailsBrand(model.getBrand()));
s.setTitle(model.getTitle());
s.setBusinessValue(model.getBusinessValue());
s.setDescription(model.getDescription());
s.setProductOwner(model.getProductOwner());
s.setLaunchDate(model.getLaunchDate());
s.setExpectedRoi(model.getExpectedRoi());
s.setLaunchYear(model.getLaunchYear());
s.setLaunchQuarter(convertToFeatureDetailsLaunchQuter(model.getLaunchQuarter()));
//s.setLaunchYear(model.getLaunchYear());

        return s;
    }






    public String insert(FeatureRequest todo) {
        RogersClientModel model = new RogersClientModel();
        model.setId(UUID.randomUUID().toString());
        model.setTitle(todo.getTitle());
        model.setLaunchYear(todo.getLaunchYear());
        model.setProductOwner(todo.getProductOwner());
      model.setLaunchQuarter(convertToFeatureDetailsLaunchQuter(todo.getLaunchQuarter()));
        model.setDescription(todo.getDescription());
        model.setLaunchDate(todo.getLaunchDate());
       model.setBrand(convertToFeatureDetailsBrand(todo.getBrand()));
        model.setExpectedRoi(todo.getExpectedRoi());
        model.setBusinessValue(todo.getBusinessValue());
        rogersClientRepo.save(model);

        // similarly set all other details to RogersClientModel
       // rogersClientRepo.save(model);
      return model.getId();




    }

    @Override
    public void updateTodo(String id,FeatureRequest featureDetails) {
RogersClientModel existing=rogersClientRepo.findByid(id);
        System.out.println(existing.toString());
       existing.setBrand(convertToFeatureDetailsBrand(featureDetails.getBrand()));
        existing.setBusinessValue(featureDetails.getBusinessValue());
        existing.setExpectedRoi(featureDetails.getExpectedRoi());
        existing.setTitle(featureDetails.getTitle());
        existing.setDescription(featureDetails.getDescription());
        existing.setLaunchDate(featureDetails.getLaunchDate());
      existing.setLaunchQuarter(convertToFeatureDetailsLaunchQuter(featureDetails.getLaunchQuarter()));
        existing.setLaunchYear(featureDetails.getLaunchYear());
        existing.setProductOwner(featureDetails.getProductOwner());
rogersClientRepo.save(existing);
    }

    @Override
    public void deleteTodo(String id) {
        RogersClientModel rogersClientModel=rogersClientRepo.findByid(id);
        if(rogersClientModel!=null){
            rogersClientModel.setIs_deleted(true);
            rogersClientRepo.save(rogersClientModel);
            }

        System.out.println("Deleted the record ");


    }


}
