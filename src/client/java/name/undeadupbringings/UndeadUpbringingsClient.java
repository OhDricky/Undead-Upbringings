package name.undeadupbringings;

import name.undeadupbringings.entity.renderer.ModEntityRendererRegistry;
import name.undeadupbringings.entity.renderer.model.ModModelRegistry;
import net.fabricmc.api.ClientModInitializer;

public class UndeadUpbringingsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModEntityRendererRegistry.initEntityRenderers();
		ModModelRegistry.initModelRegistry();
	}
}