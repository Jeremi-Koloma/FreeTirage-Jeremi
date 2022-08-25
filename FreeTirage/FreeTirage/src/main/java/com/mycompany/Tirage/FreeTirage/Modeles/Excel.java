package com.mycompany.Tirage.FreeTirage.Modeles;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Excel {
    // dire qu'on va prendre un fichier de type Excel
    public static String excelType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    // SHEET fait référence au feuille d'excel
    public static String SHEET = "Postulants";

    // Methode qui verifi si le fichier est un fichier Excel
    public static Boolean verifier(MultipartFile file) { // MultipartFile qui va prendre plusieurs ficher
        // Vérifie le contenue qui se trouve dans le fichier est de type Excel;
        if (excelType.equals(file.getContentType())) {
            return true;
        } else {
            return false;
        }
    }

    // Methode qui retourne la liste des postulants à travers le fichier excel
    // fournit
    public static List<Postulant> postulantsExcel(MultipartFile file) {

        try {
            // creation d'une liste dans la quelle on va mettre la liste recuperée
            List<Postulant> postulants = new ArrayList<>();

            // Le Workbook va nous permettre de lire le fichier
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            // Sheet fait réference au cellule d'excel;
            Iterator<Sheet> sheet = workbook.sheetIterator();
            // DataFormatter permet de recupérer les informations qui se trouve dans la cellule
            DataFormatter formatter = new DataFormatter();
            // parcourir toutes les cellule du fichier
            while (sheet.hasNext()) {
                int numeroLigne = 0;

                // saut de la premiere ligne
                Sheet sh = sheet.next();
                // Row c'est pour les lignes du fichier;
                Iterator<Row> iterator = sh.iterator();
                // parcour du fichier excel ligne par ligne;
                while (iterator.hasNext()) {
                    Row row = iterator.next();
                    Iterator<Cell> cellIterator = row.iterator();
                    // Recuperation de la ligne courante
                    // Row ligneCourante = ligne.next();
                    // on lui dit de sauter la première ligne du fichier, qui est l'entête
                    if (numeroLigne == 0) {
                        numeroLigne++;
                        continue;
                    }

                    // Après avoir recuperer une ligne, on crée un postulant et on recupère ses attributs;
                    Postulant postulant = new Postulant();

                    int numeroColonne = 0;
                    // parcour des colonnes d'une ligne
                    while (cellIterator.hasNext()) {
                        // Recuperation de la colonne courante
                        Cell colonneCourante = cellIterator.next();
                        // recuperation des infos de chaque colonne
                        switch (numeroColonne) {
                            // première colonne contenant le nom
                            case 0:
                                postulant.setEmail(formatter.formatCellValue(colonneCourante));

                                // System.out.println(colonneCourante.getStringCellValue());
                                break;
                            // deuxième colonne contenant le prenom
                            case 1:
                                postulant.setNom(formatter.formatCellValue(colonneCourante));
                                break;
                            // troixième colonne contenant le numero
                            case 2:
                                postulant.setNumero(formatter.formatCellValue(colonneCourante));
                                break;
                            // dernière colonne contenant l'adresse mail
                            case 3:
                                postulant.setPrenom(formatter.formatCellValue(colonneCourante));

                                break;
                            default:
                                break;
                        }
                        numeroColonne++;
                    }
                    postulants.add(postulant);
                    // numeroLigne++;
                }
            }
            // stoper la lecture;
            workbook.close();
            // On retourne un postulant;
            return postulants;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            // TODO: handle exception
            return null;
        }

    }
}
