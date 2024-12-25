package Restaurant.Model;
import java.util.List;

/**
 * A model that saves selected dish choices.
 */

public class FormOrderData {
    private List<String> selectedOptions;

    public List<String> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }
}
