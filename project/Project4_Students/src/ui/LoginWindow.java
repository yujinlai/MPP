/*
 * Copyright (c) 2011, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package ui;

import java.io.IOException;

import business.ControllerInterface;
import business.LoginException;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.rulesets.RuleException;
import ui.rulesets.RuleSet;
import ui.rulesets.RuleSetFactory;

public class LoginWindow extends Stage implements LibWindow {
    public static final LoginWindow INSTANCE = new LoginWindow();
    private boolean isInitialized = false;
	public boolean isInitialized() {
		return isInitialized;
	}
	public void isInitialized(boolean val) {
		isInitialized = val;
	}
	private static Stage mainWindow;
	public Stage getMainWindow() {
		return mainWindow;
	}
	public void setMainWindow(Stage mWindow) {
		mainWindow = mWindow;
	}
	private static Stage primaryStage = null;
	public Stage primStage() {
		return primaryStage;
	}
	public void setPrimStage(Stage primStage) {
		primaryStage = primStage;
	}

	@FXML
	private TextField usernameField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Text actiontarget;
	
	@FXML
	private Button button;
	
	public TextField getUsernameField() {
		return usernameField;
	}
	
	public PasswordField getPasswordField() {
		return passwordField;
	}

	public Text getActiontarget() {
		return actiontarget;
	}

	public Button getButton() {
		return button;
	}

	@Override
	public void init() {
		mainWindow = new MainWindow(primaryStage);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginWindow.fxml"));
		//fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {		
				try {
					RuleSet rules = RuleSetFactory.getRuleSet(LoginWindow.this);
					rules.applyRules(LoginWindow.this);
					ControllerInterface c = new SystemController();
					c.login(usernameField.getText().trim(), passwordField.getText().trim());
					mainWindow.show();
					primaryStage.close();
				} catch (RuleException e1) {
					actiontarget.setText("All fields must be non-empty");
				} catch (LoginException e1) {
					actiontarget.setText("Either the user name or password is wrong");
				}
			}
		});
		primaryStage.setTitle("Login");
		primaryStage.setScene(new Scene(fxmlLoader.getRoot(), 300, 275));
		primaryStage.show();	
	}
}
