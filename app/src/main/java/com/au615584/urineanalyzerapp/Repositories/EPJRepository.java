package com.au615584.urineanalyzerapp.Repositories;

import android.util.Log;

import com.au615584.urineanalyzerapp.Model.Observation.BasedOn;
import com.au615584.urineanalyzerapp.Model.Observation.Code;
import com.au615584.urineanalyzerapp.Model.Observation.Coding;
import com.au615584.urineanalyzerapp.Model.Observation.Component;
import com.au615584.urineanalyzerapp.Model.Observation.Component_Extension;
import com.au615584.urineanalyzerapp.Model.Observation.Contained;
import com.au615584.urineanalyzerapp.Model.Observation.Extension;
import com.au615584.urineanalyzerapp.Model.Observation.Extension_Extension;
import com.au615584.urineanalyzerapp.Model.Observation.Identifier;
import com.au615584.urineanalyzerapp.Model.Observation.Meta;
import com.au615584.urineanalyzerapp.Model.Observation.Observation;
import com.au615584.urineanalyzerapp.Model.Observation.Subject;
import com.au615584.urineanalyzerapp.Model.Observation.Type;
import com.au615584.urineanalyzerapp.Model.Observation.ValueCoding;
import com.au615584.urineanalyzerapp.Model.Observation.ValueQuantity;
import com.au615584.urineanalyzerapp.Model.Observation.ValueReference;
import com.au615584.urineanalyzerapp.ObservationService;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EPJRepository implements IEPJRepository {
    //Instance for Singleton pattern
    private static EPJRepository instance;
    private ObservationService obsService;

    EPJRepository() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("EPJ URL") //TODO JEG TROR DET ER HER, VI SKAL SÆTTE NOGET IND
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obsService = retrofit.create(ObservationService.class);*/
    }

    public ObservationService getObsService(){
        return obsService;
    }

    //Singleton patten
    public static EPJRepository getInstance() {

        if (instance == null) {
            instance = new EPJRepository();
        }
        return instance;
    }


    public Observation createObservation(double Glukose, double Albumin, String CPR) {
        Observation obs = new Observation();

        obs.setResourceType("Observation");

        List<Contained> contained = new ArrayList<>();
        //Creation contained location
        Contained containedLocation = new Contained();
        containedLocation.setResourceType("Location");
        containedLocation.setId("1");
        Meta metaLocation = new Meta();
        List<String> profileLocation = new ArrayList<>();
        profileLocation.add("http://columnafhir.dk/p/ColumnaLocation");
        metaLocation.setProfile(profileLocation);

        containedLocation.setMeta(metaLocation);

        Identifier identifierLocation1 = new Identifier();
        identifierLocation1.setSystem("http://sundhedsdatastyrelsen.dk/shakIdentifier");
        identifierLocation1.setValue("7026");

        Identifier identifierLocation2 = new Identifier();
        identifierLocation2.setSystem("http://www.sundhedsdatastyrelsen.dk/SOR/SorIdentifier");
        identifierLocation2.setValue("272781000016007");


        List<Identifier> identifiersLocation = new ArrayList<>();
        identifiersLocation.add(identifierLocation1);
        identifiersLocation.add(identifierLocation2);
        containedLocation.setIdentifier(identifiersLocation);

        containedLocation.setName("skejby sygehus");

        List<Coding> codingsLocation = new ArrayList<>();
        Coding codingLocation = new Coding();
        codingLocation.setSystem("http://www.systematic.com/CIS/LocationType");
        codingLocation.setCode("hospital");
        codingLocation.setDisplay("Hospital");

        codingsLocation.add(codingLocation);
        Type typeLocation = new Type();
        typeLocation.setCoding(codingsLocation);
        containedLocation.setType(typeLocation);



        //Creating Contained ProcedureRequest
        Contained containedProcedure = new Contained();
        containedProcedure.setResourceType("ProcedureRequest");
        containedProcedure.setId("3");
        Meta metaProcedure = new Meta();
        List<String> profileProcedure = new ArrayList<>();
        profileProcedure.add("http://columnafhir.dk/p/ColumnaActivityRequest");
        metaProcedure.setProfile(profileProcedure);

        containedProcedure.setMeta(metaProcedure);
        containedProcedure.setStatus("active");
        containedProcedure.setIntent("plan");

        List<Coding> codingsProcedure = new ArrayList<>();;
        Coding codingProcedure = new Coding();
        codingProcedure.setSystem("http://columnafhir.dk/cs/moid/activity");
        codingProcedure.setCode("KPKlKlassif:KPYdelser.Afdelingsydelser.Afdelingsydelser.Undersøgelser.USUrinstiks");
        codingProcedure.setDisplay("Urinstiks");

        codingsProcedure.add(codingProcedure);
        Type typeProcedure = new Type();
        typeProcedure.setCoding(codingsProcedure);
        containedProcedure.setType(typeProcedure);

        //Adding both containd to list of contained and adding to obs
        contained.add(containedLocation);
        contained.add(containedProcedure);
        obs.setContained(contained);

        //Creating extensionsList
        List<Extension> extensionList = new ArrayList<>();;

        //Creating first extension
        Extension extension1 = new Extension();
        extension1.setUrl("http://columnafhir.dk/x/ColumnaActivityResult-speciality");


        //Creating extensions in extensions
        List<Extension_Extension> extenionsInExtensionList = new ArrayList<>();;
        Extension_Extension extensionInExtension1 = new Extension_Extension();
        extensionInExtension1.setUrl("http://columnafhir.dk/x/ColumnaActivityResult-speciality/code");
        ValueCoding valueCoding = new ValueCoding();
        valueCoding.setSystem("http://columnafhir.dk/vs/specialty");
        valueCoding.setCode("038");
        valueCoding.setDisplay("gynækologi og obstetrik");

        extensionInExtension1.setValueCoding(valueCoding);
        extenionsInExtensionList.add(extensionInExtension1);

        Extension_Extension extensionInExtension2 = new Extension_Extension();
        extensionInExtension2.setUrl("http://columnafhir.dk/x/ColumnaActivityResult-speciality/hospital");
        ValueReference valureReference = new ValueReference();
        valureReference.setReference("#1");
        extensionInExtension2.setValueReference(valureReference);
        extenionsInExtensionList.add(extensionInExtension2);

        //Adding extensionsInExtensions to extension
        extension1.setExtension(extenionsInExtensionList);

        //Creating second extension
        Extension extension2 = new Extension();
        extension2.setUrl("http://columnafhir.dk/x/ColumnaActivityResult-effective-date-time");
        extension2.setValueDateTime("2022-11-08T13:17:00.000+01:00"); //TODO denne skal måske være dynamisk?

        //Adding extenions to list of extions and adding to observation
        extensionList.add(extension1);
        extensionList.add(extension2);
        obs.setExtension(extensionList);


        //Creating BasedOn
        BasedOn basedOn = new BasedOn();
        basedOn.setReference("#3");
        obs.setBasedOn(basedOn);

        obs.setStatus("final");

        //Creating code
        Code code = new Code();

        //Creating coding in code
        List<Coding> codingList = new ArrayList<>();;
        Coding coding = new Coding();
        coding.setSystem("http://columnafhir.dk/cs/moid/result");
        coding.setCode("TestKPKlResults:hbdUrinstiks");
        coding.setDisplay("Urinstiks");

        codingList.add(coding);

        code.setCoding(codingList);

        obs.setCode(code);

        //Adding subject to observation
        Subject subject = new Subject();
        subject.setReference("Patient?identifier=http://cpr.dk/personregistret|0707076LK1&_profile=http://columnafhir.dk/p/ColumnaPatient");

        obs.setSubject(subject); //TODO find ud af hvordan cpr nummer skal tilføjes

        //Adding componentList to observation
        List<Component> componentList = new ArrayList<>();

        //Creating first component
        Component component1 = new Component();

        List<Component_Extension> component1_extensionList = new ArrayList<>();
        Component_Extension component1_extension = new Component_Extension();
        component1_extension.setUrl("http://columnafhir.dk/x/ObservationComponentComponent-value-quantity");


        ValueQuantity valueQuantityAlbumin = new ValueQuantity();
        valueQuantityAlbumin.setValue(Albumin); //TODO her sættes Albumin resultat
        component1_extension.setValueQuantity(valueQuantityAlbumin);


        component1_extensionList.add(component1_extension);

        component1.setExtension(component1_extensionList);

        Code codeInComponent = new Code();
        List<Coding> codingInCodeList = new ArrayList<>();
        Coding codingInCode = new Coding();
        codingInCode.setSystem("http://columnafhir.dk/cs/moid/result-element");
        codingInCode.setCode("TestKPKlResults:hbdUrinstiks.edUSAlbumin");
        codingInCode.setDisplay("Albumin antal +'er");

        codingInCodeList.add(codingInCode);

        codeInComponent.setCoding(codingInCodeList);
        component1.setCode(codeInComponent);
        componentList.add(component1);

        //Creating second component
        Component component2 = new Component();
        Component_Extension component2_Extension = new Component_Extension();
        List<Component_Extension> component2_ExtensionList = new ArrayList<>();

        component2_Extension.setUrl("http://columnafhir.dk/x/ObservationComponentComponent-value-quantity");
        ValueQuantity valueQuantityGlucosis = new ValueQuantity();
        valueQuantityGlucosis.setValue(Glukose); //TODO her sættes glukose resultat

        component2_Extension.setValueQuantity(valueQuantityGlucosis);

        component2_ExtensionList.add(component2_Extension);
        component2.setExtension(component2_ExtensionList);

        //Adding code to component2
        Code component2_code = new Code();
        List<Coding> component2_code_codingList = new ArrayList<>();
        Coding component2_code_coding = new Coding();
        component2_code_coding.setSystem("http://columnafhir.dk/cs/moid/result-element");
        component2_code_coding.setCode("TestKPKlResults:hbdUrinstiks.edUSSukker");
        component2_code_coding.setDisplay("Sukker antal +'er");

        component2_code_codingList.add(component2_code_coding);
        component2_code.setCoding(component2_code_codingList);
        component2.setCode(component2_code);
        componentList.add(component2);


        //Creating third component
        Component component3 = new Component();
        Code component3_code = new Code();
        List<Coding> component3_code_codingList = new ArrayList<>();
        Coding component3_code_coding = new Coding();
        component3_code_coding.setSystem("http://columnafhir.dk/cs/moid/result-element");
        component3_code_coding.setCode("TestKPKlResults:hbdUrinstiks.edUSBlod");
        component3_code_coding.setDisplay("Blod antal +'er");

        component3_code_codingList.add(component3_code_coding);
        component3_code.setCoding(component3_code_codingList);
        component3.setCode(component3_code);
        componentList.add(component3);


        //Creating fourth component
        Component component4 = new Component();
        Code component4_code = new Code();
        List<Coding> component4_code_codingList = new ArrayList<>();
        Coding component4_code_coding = new Coding();
        component4_code_coding.setSystem("http://columnafhir.dk/cs/moid/result-element");
        component4_code_coding.setCode("TestKPKlResults:hbdUrinstiks.edUSLeucocytter");
        component4_code_coding.setDisplay("Leucocytter antal +'er");

        component4_code_codingList.add(component4_code_coding);
        component4_code.setCoding(component4_code_codingList);
        component4.setCode(component4_code);
        componentList.add(component4);


        //Creating fifth component
        Component component5 = new Component();
        Code component5_code = new Code();
        List<Coding> component5_code_codingList = new ArrayList<>();
        Coding component5_code_coding = new Coding();
        component5_code_coding.setSystem("http://columnafhir.dk/cs/moid/result-element");
        component5_code_coding.setCode("TestKPKlResults:hbdUrinstiks.edUSNitrit");
        component5_code_coding.setDisplay("Nitrit antal +'er");

        component5_code_codingList.add(component5_code_coding);
        component5_code.setCoding(component5_code_codingList);
        component5.setCode(component5_code);
        componentList.add(component5);


        //Creating sixth component
        Component component6 = new Component();
        Code component6_code = new Code();
        List<Coding> component6_code_codingList = new ArrayList<>();
        Coding component6_code_coding = new Coding();
        component6_code_coding.setSystem("http://columnafhir.dk/cs/moid/result-element");
        component6_code_coding.setCode("TestKPKlResults:hbdUrinstiks.edUSKetonstoffer");
        component6_code_coding.setDisplay("Ketonstoffer antal +'er");

        component6_code_codingList.add(component6_code_coding);
        component6_code.setCoding(component6_code_codingList);
        component6.setCode(component6_code);
        componentList.add(component6);


        //adding list of components to observation
        obs.setComponent(componentList);

        return obs;
    }

    public void saveToFile(double Glukose, double Albumin, String Cpr) {
        Observation obs = createObservation(Glukose, Albumin, Cpr);
    }

    @Override
    public void saveToEPJ(double Albumin, double Glukose, String Cpr) {
        Observation obs = createObservation(Albumin, Glukose, Cpr);
        instance.getObsService().createObservation(obs).enqueue(new Callback<Observation>() {

            @Override
            public void onResponse(Call<Observation> call, Response<Observation> response) {
                Log.d("EPJREP", "Observation"+response.body().getSubject());
            }

            @Override
            public void onFailure(Call<Observation> call, Throwable t) {
                Log.d("EPJREP", "Error creating Observation");
            }
        });
    }
}
