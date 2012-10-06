package com.fer.librosViejos.client.pages.crearAnuncio;

import java.util.List;

import com.fer.librosViejos.client.model.ImageResult;
import com.fer.librosViejos.client.pages.crearAnuncio.widget.ImageResultPanel;
import com.fer.librosViejos.client.services.imageSearch.ImageSearchService;
import com.fer.librosViejos.client.services.imageSearch.ImageSearchServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CrearAnuncioUI extends Composite {

	private static CrearAnuncioUIUiBinder uiBinder = GWT
			.create(CrearAnuncioUIUiBinder.class);

	interface CrearAnuncioUIUiBinder extends UiBinder<Widget, CrearAnuncioUI> {
	}

	@UiField Button btnSend;
	@UiField TextBox txtName;
	@UiField InputElement txtPrice;
	@UiField TextAreaElement txtDesc;
	@UiField Panel imagesPanel;
	
	private ImageResultPanel imageResPanel;
	
	private ImageSearchServiceAsync serviceImages = GWT.create(ImageSearchService.class);
	
	
	public CrearAnuncioUI() {
		initWidget(uiBinder.createAndBindUi(this));
		
		txtName.getElement().setPropertyString("placeholder", "Nombre del Anuncio");
	}
	
	@UiHandler("txtName")
	public void onBlur(BlurEvent b)
	{
		serviceImages.searchImages(txtName.getValue(), new AsyncCallback<List<ImageResult>>() {
			
			@Override
			public void onSuccess(List<ImageResult> result) {
				imagesPanel.clear();
				imageResPanel = new ImageResultPanel(result);
				imagesPanel.add(imageResPanel);
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}
		});
	}
	
	public InputElement getPrice()
	{
		return txtPrice;
	}
	
	public Button getSendButton()
	{
		return btnSend;
	}
	
	public TextBox getName()
	{
		return txtName;
	}
	
	public TextAreaElement getDescr()
	{
		return txtDesc;
	}
	
	public ImageResultPanel getImagePanel()
	{
		return imageResPanel;
	}

}
