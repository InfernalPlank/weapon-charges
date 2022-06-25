package com.weaponcharges;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Keybind;

@ConfigGroup(WeaponChargesPlugin.CONFIG_GROUP_NAME)
public interface WeaponChargesConfig extends Config
{
	@ConfigItem(
		keyName = "chargesTextRegularColor",
		name = "Charge Text Color",
		description = "The color to display charge count text in when charges are not low.",
		position = 0
	)
	default Color chargesTextRegularColor()
	{
		return Color.WHITE;
	}

	@ConfigItem(
		keyName = "chargesTextLowColor",
		name = "Low Charge Text Color",
		description = "The color to display charge count text in when charges are low.",
		position = 1
	)
	default Color chargesTextLowColor()
	{
		return Color.RED;
	}

	enum DisplayWhenNoDefault {
		ALWAYS,
		LOW_CHARGE,
		NEVER,
		;

		public static DisplayWhen getDisplayWhen(DisplayWhen specificDisplayWhen, DisplayWhenNoDefault defaultDisplayWhen)
		{
			if (specificDisplayWhen != DisplayWhen.USE_DEFAULT) return specificDisplayWhen;
			switch (defaultDisplayWhen) {
				case ALWAYS:
					return DisplayWhen.ALWAYS;
				case LOW_CHARGE:
					return DisplayWhen.LOW_CHARGE;
				case NEVER:
					return DisplayWhen.NEVER;
				default:
					throw new IllegalStateException("Unexpected value: " + defaultDisplayWhen);
			}
		}
	}

	@ConfigItem(
		keyName = "defaultDisplay",
		name = "Show Charges",
		description = "When weapons should show their charges, if you haven't specified anything for that weapon in \"" + WEAPON_SPECIFIC_SETTING + "\".",
		position = 2
	)
	default DisplayWhenNoDefault defaultDisplay()
	{
		return DisplayWhenNoDefault.ALWAYS;
	}

	@ConfigItem(
		keyName = WeaponChargesPlugin.DEV_MODE_CONFIG_KEY,
		name = "log data",
		description = "fills your logs with stuff, if you're collecting game messages/dialogs that have to do with weapon charges.",
		position = 3
	)
	default boolean devMode()
	{
		return false;
	}

	@ConfigItem(
		keyName = "showOnHotkey",
		name = "Always show charge when held",
		description = "When this key is held, show charges on all tracked weapons.",
		position = 4
	)
	default Keybind showOnHotkey()
	{
		return Keybind.ALT;
	}

	enum DisplayWhen {
		USE_DEFAULT,
		ALWAYS,
		LOW_CHARGE,
		NEVER,
	}

	@ConfigSection(
		name = "Weapon Specific Config",
		description = "Specify display and low charge threshold values for specific weapons.",
		position = 5,
		closedByDefault = true
	)
	String WEAPON_SPECIFIC_SETTING = "weaponSpecificConfig";

	@ConfigItem(
		keyName = "blowpipe_display",
		name = "Blowpipe",
		description = "When the Blowpipe should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = -2
	)
	default WeaponChargesConfig.DisplayWhen blowpipe_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "blowpipe_low_charge_threshold",
		name = "Low (Blowpipe)",
		description = "Number of charges considered \"low\". Calculated as number of shots before the Blowpipe runs out of either scales or darts, assuming the assembler is used.",
		section = WEAPON_SPECIFIC_SETTING,
		position = -1
	)
	default int blowpipe_LowChargeThreshold()
	{
		return 1500;
	}

	// begin autogenerated
	@ConfigItem(
		keyName = "trident_of_the_seas_display",
		name = "Seas trident",
		description = "When the Seas trident should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 0
	)
	default WeaponChargesConfig.DisplayWhen trident_of_the_seas_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "trident_of_the_seas_low_charge_threshold",
		name = "Low (Seas trident)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 1
	)
	default int trident_of_the_seas_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "trident_of_the_swamp_display",
		name = "Swamp trident",
		description = "When the Swamp trident should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 2
	)
	default WeaponChargesConfig.DisplayWhen trident_of_the_swamp_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "trident_of_the_swamp_low_charge_threshold",
		name = "Low (Swamp trident)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 3
	)
	default int trident_of_the_swamp_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "trident_of_the_seas_e_display",
		name = "Seas trident (e)",
		description = "When the Seas trident (e) should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 4
	)
	default WeaponChargesConfig.DisplayWhen trident_of_the_seas_e_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "trident_of_the_seas_e_low_charge_threshold",
		name = "Low (Seas trident (e))",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 5
	)
	default int trident_of_the_seas_e_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "trident_of_the_swamp_e_display",
		name = "Swamp trident (e)",
		description = "When the Swamp trident (e) should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 6
	)
	default WeaponChargesConfig.DisplayWhen trident_of_the_swamp_e_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "trident_of_the_swamp_e_low_charge_threshold",
		name = "Low (Swamp trident (e))",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 7
	)
	default int trident_of_the_swamp_e_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "ibans_staff_display",
		name = "Iban's staff",
		description = "When the Iban's staff should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 8
	)
	default WeaponChargesConfig.DisplayWhen ibans_staff_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "ibans_staff_low_charge_threshold",
		name = "Low (Iban's staff)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 9
	)
	default int ibans_staff_LowChargeThreshold()
	{
		return 250;
	}

	@ConfigItem(
		keyName = "crystal_halberd_display",
		name = "Crystal halberd",
		description = "When the Crystal halberd should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 10
	)
	default WeaponChargesConfig.DisplayWhen crystal_halberd_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "crystal_halberd_low_charge_threshold",
		name = "Low (Crystal halberd)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 11
	)
	default int crystal_halberd_LowChargeThreshold()
	{
		return 25;
	}

	@ConfigItem(
		keyName = "abyssal_tentacle_display",
		name = "Abyssal tentacle",
		description = "When the Abyssal tentacle should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 12
	)
	default WeaponChargesConfig.DisplayWhen abyssal_tentacle_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "abyssal_tentacle_low_charge_threshold",
		name = "Low (Abyssal tentacle)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 13
	)
	default int abyssal_tentacle_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "tome_of_fire_display",
		name = "Tome of fire",
		description = "When the Tome of fire should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 14
	)
	default WeaponChargesConfig.DisplayWhen tome_of_fire_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "tome_of_fire_low_charge_threshold",
		name = "Low (Tome of fire)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 15
	)
	default int tome_of_fire_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "tome_of_water_display",
		name = "Tome of water",
		description = "When the Tome of water should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 16
	)
	default WeaponChargesConfig.DisplayWhen tome_of_water_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "tome_of_water_low_charge_threshold",
		name = "Low (Tome of water)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 17
	)
	default int tome_of_water_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "scythe_of_vitur_display",
		name = "Scythe of vitur",
		description = "When the Scythe of vitur should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 18
	)
	default WeaponChargesConfig.DisplayWhen scythe_of_vitur_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "scythe_of_vitur_low_charge_threshold",
		name = "Low (Scythe of vitur)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 19
	)
	default int scythe_of_vitur_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "sanguinesti_staff_display",
		name = "Sanguinesti staff",
		description = "When the Sanguinesti staff should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 20
	)
	default WeaponChargesConfig.DisplayWhen sanguinesti_staff_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "sanguinesti_staff_low_charge_threshold",
		name = "Low (Sanguinesti staff)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 21
	)
	default int sanguinesti_staff_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "arclight_display",
		name = "Arclight",
		description = "When the Arclight should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 22
	)
	default WeaponChargesConfig.DisplayWhen arclight_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "arclight_low_charge_threshold",
		name = "Low (Arclight)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 23
	)
	default int arclight_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "craws_bow_display",
		name = "Craw's bow",
		description = "When the Craw's bow should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 24
	)
	default WeaponChargesConfig.DisplayWhen craws_bow_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "craws_bow_low_charge_threshold",
		name = "Low (Craw's bow)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 25
	)
	default int craws_bow_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "viggoras_chainmace_display",
		name = "Viggora's chainmace",
		description = "When Viggora's chainmace should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 26
	)
	default WeaponChargesConfig.DisplayWhen viggoras_chainmace_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "viggoras_chainmace_low_charge_threshold",
		name = "Low (Viggora's chainmace)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 27
	)
	default int viggoras_chainmace_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "thammarons_sceptre_display",
		name = "Thammaron's sceptre",
		description = "When Thammaron's sceptre should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 28
	)
	default WeaponChargesConfig.DisplayWhen thammarons_sceptre_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "thammarons_sceptre_low_charge_threshold",
		name = "Low (Thammaron's sceptre)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 29
	)
	default int thammarons_sceptre_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "crystal_bow_display",
		name = "Crystal bow",
		description = "When Crystal bow should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 30
	)
	default WeaponChargesConfig.DisplayWhen crystal_bow_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "crystal_bow_low_charge_threshold",
		name = "Low (Crystal bow)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 31
	)
	default int crystal_bow_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "bow_of_faerdhinen_display",
		name = "Bow of faerdhinen",
		description = "When the Bow of faerdhinen should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 32
	)
	default WeaponChargesConfig.DisplayWhen bow_of_faerdhinen_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "bow_of_faerdhinen_low_charge_threshold",
		name = "Low (Bow of faerdhinen)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 33
	)
	default int bow_of_faerdhinen_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "crystal_armour_display",
		name = "Crystal armor",
		description = "When the Crystal armor should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 34
	)
	default WeaponChargesConfig.DisplayWhen crystal_armour_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "crystal_armour_low_charge_threshold",
		name = "Low (Crystal armor)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 35
	)
	default int crystal_armour_LowChargeThreshold()
	{
		return 500;
	}

	@ConfigItem(
		keyName = "serpentine_helm_display",
		name = "Serpentine helm",
		description = "When the Serpentine helm should show the charge counter.",
		section = WEAPON_SPECIFIC_SETTING,
		position = 36
	)
	default WeaponChargesConfig.DisplayWhen serpentine_helm_Display()
	{
		return WeaponChargesConfig.DisplayWhen.USE_DEFAULT;
	}

	@ConfigItem(
		keyName = "serpentine_helm_low_charge_threshold",
		name = "Low (Serpentine helm)",
		description = "Number of charges considered \"low\".",
		section = WEAPON_SPECIFIC_SETTING,
		position = 38
	)
	default int serpentine_helm_LowChargeThreshold()
	{
		return 500;
	}
	// end autogenerated

	enum SerpModes {
		SCALES,
		PERCENT,
		BOTH,
	}

	@ConfigItem(
			keyName = "serpentine_helm_display_style",
			name = "Serp display style",
			description = "How the Serpentine helm should show the charge counter.",
			section = WEAPON_SPECIFIC_SETTING,
			position = 37
	)
	default WeaponChargesConfig.SerpModes serpentine_helm_DisplayStyle()
	{
		return WeaponChargesConfig.SerpModes.PERCENT;
	}
}
