import co.edu.uptc.interfaces.VetInterface;
import co.edu.uptc.models.VetModel;
import co.edu.uptc.presenters.PresenterVet;
import co.edu.uptc.views.mainpage.MainPageFrame;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        VetInterface.Presenter presenter = new PresenterVet();
        VetInterface.Model model = new VetModel();

        presenter.setModel(model);
        model.setPresenter(presenter);

        VetInterface.View view = new MainPageFrame();
        view.setPresenter(presenter);
        presenter.setView(view);
        presenter.start();
        view.start();
    }
}
