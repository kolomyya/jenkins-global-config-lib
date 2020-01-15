#!/usr/bin/env groovy
package com.lib
import groovy.json.JsonSlurper
import hudson.FilePath

node { 
    deleteDir() 
    stage("upload") { 
        def inputFile = input message: 'Upload file', parameters: [file(name: 'restaurantConfigCSV')] 
        new hudson.FilePath(new File("$workspace/restaurantConfigCSV")).copyFrom(inputFile) 
        inputFile.delete() 
    }
    

    stage("checkout") { 
     echo fileExists('restaurantConfigCSV').toString() 
    stage("read") {
        def filenames = readFile 'restaurantConfigCSV'
        def filenameArray = filenames.split(",")
        for(int i = 0; i < filenameArray.size(); i++) {
        def file = filenameArray[i]
        echo file
    }   
    }    
    } 
    } 