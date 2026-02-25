package so.kernel.client.skin;

import javax.swing.plaf.metal.MetalLookAndFeel;

public class AWMetalLookAndFeel extends MetalLookAndFeel {

	static {
		MetalLookAndFeel.setCurrentTheme(new AWDefaultMetalTheme());
	}

	@Override
	protected void createDefaultTheme() {
		MetalLookAndFeel.setCurrentTheme(new AWDefaultMetalTheme());
	}
}
