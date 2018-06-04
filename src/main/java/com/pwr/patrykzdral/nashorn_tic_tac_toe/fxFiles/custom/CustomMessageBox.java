package com.pwr.patrykzdral.nashorn_tic_tac_toe.fxFiles.custom;

import javafx.scene.control.Alert;

/**
 * <p>CustomMessageBox class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
public class CustomMessageBox {

    public CustomMessageBox() {

    }

    /**
     * <p>showMessageBox.</p>
     *
     * @param alertType a javafx.scene.control.Alert$AlertType object.
     * @param title a {@link String} object.
     * @param header a {@link String} object.
     * @param content a {@link String} object.
     * @return a javafx.scene.control.Alert object.
     */
    public Alert showMessageBox(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        return alert;
    }
}
