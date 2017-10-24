package com.morfly.cleanarchitecture.core.presentationlayer;


public interface BaseView {

    /**
     * Method for retrieving viewModel layout BR (binding resource) variable
     *
     * @return viewModel layout BR
     */
    int getViewModelBindingId();

    /**
     * Applies viewModel to the layout through dataBinding
     *
     * @param viewModelBindingId viewModel BR variable
     * @param viewModel          viewModel to set
     */
    void setViewModel(int viewModelBindingId, Object viewModel);

    void showProgress();

    void hideProgress();

    void showMessage(String message);

    void showMessage(int stringResId, Object... args);

    void showError(Throwable throwable);

    void hideSoftKeyboard();

    void performBackAction();

}
