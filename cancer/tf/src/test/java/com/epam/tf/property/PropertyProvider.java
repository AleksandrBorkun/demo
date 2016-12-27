package com.epam.tf.property;

import java.util.ResourceBundle;

/**
 * Refactor by Nikolay_Golubitsky on 12/7/2016
 */
public class PropertyProvider {

        private static final String CONFIG_PATH = "config";
        private static final ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_PATH);

        public static String getProperty(String propertyName) {
            return bundle.getString(propertyName);
        }
}

