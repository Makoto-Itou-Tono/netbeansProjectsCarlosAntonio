package Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;//traer un archivo 
import net.sf.jasperreports.view.JasperDesignViewer;//visualizar
import net.sf.jasperreports.view.JasperViewer;
import Model.*;

public class ControllerReports {

    Conecction con = new Conecction();

    public void executeReport() {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReports.class.getResource("/Reports/MyReportOne.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            Logger.getLogger(ControllerReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void executeReportWithParameters(String title) {

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReports.class.getResource("/Reports/MyReportOne.jasper"));
            Map parameters = new HashMap<String, Object>();//preparar con un jasper view
            parameters.put("title", title);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "ERROR JRException " + ex.getMessage());
        }

    }

    public void executeReportWithSql() {

        try {
            //el objeto
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReports.class.getResource("/Reports/ReportWithSqlAndParameter.jasper"));//
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConnection());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "ERROR JRException " + ex.getMessage());
        }
    }

    public void executeReportWhithParametersAndSql(String dni) {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReports.class.getResource("/Reports/report1.jasper"));
            Map parameters = new HashMap<String, Object>();//preparar con un jasper view
            parameters.put("dni", dni);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con.getConnection());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "ERROR JRException " + ex.getMessage());
        }

    }
    public void executeReportWhitRange(String datestar,String dateend) {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReports.class.getResource("/Reports/rango.jasper"));
            Map parameters = new HashMap<String, Object>();//preparar con un jasper view
            parameters.put("datestart", datestar);
            parameters.put("dateend",dateend);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con.getConnection());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "ERROR JRException " + ex.getMessage());
        }
    }


    public void executeBarChartReport() {
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ControllerReports.class.getResource("/Reports/BarChartReport.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getConnection());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Error JRExcepcion" + ex.getMessage());

        }
    }
}
