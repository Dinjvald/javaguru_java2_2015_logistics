package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.AgreementDAOImpl;
import lv.javaguru.java2.domain.Agreement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAgreementController implements MVCController {


    @Override
    public MVCModel processRequest(HttpServletRequest request,
                                   HttpServletResponse response) {

        Long cargoId = Long.parseLong(request.getParameter("cargoId"));
        Long vehicleId = Long.parseLong(request.getParameter("vehicleId"));
        String status = "New";
        Agreement agreement = new Agreement(cargoId, vehicleId, status);
        AgreementDAOImpl agreementDAO = new AgreementDAOImpl();

        try {
            agreementDAO.create(agreement);
        } catch (DBException e) {
            System.out.println("Exception while creating new agreement in CreateAgreementController()");
            e.printStackTrace();
        }

        return new MVCModel("/jsp/newAgreement.jsp", agreement);
    }
}
