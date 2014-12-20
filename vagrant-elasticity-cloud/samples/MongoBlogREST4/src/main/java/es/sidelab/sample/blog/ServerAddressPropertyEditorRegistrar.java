package es.sidelab.sample.blog;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.data.mongodb.config.ServerAddressPropertyEditor;

import com.mongodb.ServerAddress;

public final class ServerAddressPropertyEditorRegistrar implements
		PropertyEditorRegistrar {

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(ServerAddress[].class, new ServerAddressPropertyEditor());
	}

}
