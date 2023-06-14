module com.doo.rushingtraining {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.doo.rushingtraining.controller;
    exports com.doo.rushingtraining.controller;

    opens com.doo.rushingtraining.model.entities;
    exports com.doo.rushingtraining.model.entities;

    opens com.doo.rushingtraining.view;
    exports com.doo.rushingtraining.view;


}