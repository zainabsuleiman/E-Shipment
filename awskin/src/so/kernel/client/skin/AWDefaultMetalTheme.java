package so.kernel.client.skin;

import javax.swing.UIDefaults;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

public class AWDefaultMetalTheme extends DefaultMetalTheme {
	private final ColorUIResource primary1 = new ColorUIResource(154, 170, 194);

	private final ColorUIResource primary2 = new ColorUIResource(154, 170, 194);

	private final ColorUIResource primary3 = new ColorUIResource(209, 216, 227);

	private final ColorUIResource secondary1 = new ColorUIResource(154, 170, 194);

	private final ColorUIResource secondary2 = new ColorUIResource(154, 170, 194);

	private final ColorUIResource secondary3 = new ColorUIResource(209, 216, 227);

	private final ColorUIResource black = new ColorUIResource(0, 0, 0);

	private final ColorUIResource blue = new ColorUIResource(0, 161, 222);

	@Override
	public void addCustomEntriesToTable(UIDefaults table) {
		Object[] defaults = new Object[] { "OptionPane.questionDialog.titlePane.foreground", new ColorUIResource(0, 51, 0),
				"OptionPane.questionDialog.titlePane.background", this.secondary3, "OptionPane.questionDialog.titlePane.shadow", this.secondary2 };
		table.putDefaults(defaults);
	}

	@Override
	protected ColorUIResource getBlack() {
		return this.black;
	}

	@Override
	public ColorUIResource getControlTextColor() {
		return this.getBlack();
	}

	@Override
	public ColorUIResource getMenuForeground() {
		return this.getBlack();
	}

	@Override
	public ColorUIResource getMenuSelectedBackground() {
		return this.blue;
	}

	@Override
	public ColorUIResource getMenuSelectedForeground() {
		return this.getBlack();
	}

	@Override
	public String getName() {
		return "ASYCUDAWorld Rwanda Theme";
	}

	@Override
	protected ColorUIResource getPrimary1() {
		return this.primary1;
	}

	@Override
	protected ColorUIResource getPrimary2() {
		return this.primary2;
	}

	@Override
	protected ColorUIResource getPrimary3() {
		return this.primary3;
	}

	@Override
	protected ColorUIResource getSecondary1() {
		return this.secondary1;
	}

	@Override
	protected ColorUIResource getSecondary2() {
		return this.secondary2;
	}

	@Override
	protected ColorUIResource getSecondary3() {
		return this.secondary3;
	}

	@Override
	public ColorUIResource getSystemTextColor() {
		return this.getBlack();
	}

	@Override
	public ColorUIResource getUserTextColor() {
		return this.getBlack();
	}
}
