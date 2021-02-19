package com.reactnativenavigation.options;

import android.content.Context;

import com.reactnativenavigation.options.params.BoolParam;
import com.reactnativenavigation.options.params.Colour;
import com.reactnativenavigation.options.params.NullBoolParam;
import com.reactnativenavigation.options.params.NullColor;
import com.reactnativenavigation.options.params.NullIntParam;
import com.reactnativenavigation.options.params.NullStringParam;
import com.reactnativenavigation.options.params.IntParam;
import com.reactnativenavigation.options.params.StringParam;
import com.reactnativenavigation.options.parsers.BoolParser;
import com.reactnativenavigation.options.parsers.ColorParser;
import com.reactnativenavigation.options.parsers.FontParser;
import com.reactnativenavigation.options.parsers.IconParser;
import com.reactnativenavigation.options.parsers.NumberParser;
import com.reactnativenavigation.options.parsers.TextParser;
import com.reactnativenavigation.options.parsers.TypefaceLoader;

import org.json.JSONObject;

public class BottomTabOptions {

    public static BottomTabOptions parse(Context context, TypefaceLoader typefaceManager, JSONObject json) {
        BottomTabOptions options = new BottomTabOptions();
        if (json == null) return options;

        options.text = TextParser.parse(json, "text");
        options.textColor = ColorParser.parse(context, json, "textColor");
        options.selectedTextColor = ColorParser.parse(context, json, "selectedTextColor");
        options.icon = IconParser.parse(json, "icon");
        options.iconWidth = NumberParser.parse(json, "iconWidth");
        options.iconHeight = NumberParser.parse(json, "iconHeight");
        options.selectedIcon = IconParser.parse(json, "selectedIcon");
        options.iconColor = ColorParser.parse(context, json, "iconColor");
        options.selectedIconColor = ColorParser.parse(context, json, "selectedIconColor");
        options.badge = TextParser.parse(json, "badge");
        options.badgeColor = ColorParser.parse(context, json, "badgeColor");
        options.animateBadge = BoolParser.parse(json, "animateBadge");
        options.testId = TextParser.parse(json, "testID");
        options.font = FontParser.parse(json);
        options.fontSize = NumberParser.parse(json, "fontSize");
        options.selectedFontSize = NumberParser.parse(json, "selectedFontSize");
        options.dotIndicator = DotIndicatorOptions.parse(context, json.optJSONObject("dotIndicator"));
        options.selectTabOnPress = BoolParser.parse(json, "selectTabOnPress");

        return options;
    }

    public StringParam text = NullStringParam.INSTANCE;
    public Colour textColor = NullColor.INSTANCE;
    public Colour selectedTextColor = NullColor.INSTANCE;
    public StringParam icon = NullStringParam.INSTANCE;
    public IntParam iconWidth = NullIntParam.INSTANCE;
    public IntParam iconHeight = NullIntParam.INSTANCE;
    public StringParam selectedIcon = NullStringParam.INSTANCE;
    public Colour iconColor = NullColor.INSTANCE;
    public Colour selectedIconColor = NullColor.INSTANCE;
    public StringParam testId = NullStringParam.INSTANCE;
    public StringParam badge = NullStringParam.INSTANCE;
    public Colour badgeColor = NullColor.INSTANCE;
    public BoolParam animateBadge = NullBoolParam.INSTANCE;
    public DotIndicatorOptions dotIndicator = new DotIndicatorOptions();
    public IntParam fontSize = NullIntParam.INSTANCE;
    public IntParam selectedFontSize = NullIntParam.INSTANCE;
    public BoolParam selectTabOnPress = NullBoolParam.INSTANCE;
    public FontOptions font = new FontOptions();


    void mergeWith(final BottomTabOptions other) {
        if (other.text.hasValue()) text = other.text;
        if (other.textColor.hasValue()) textColor = other.textColor;
        if (other.selectedTextColor.hasValue()) selectedTextColor = other.selectedTextColor;
        if (other.icon.hasValue()) icon = other.icon;
        if (other.iconWidth.hasValue()) iconWidth = other.iconWidth;
        if (other.iconHeight.hasValue()) iconHeight = other.iconHeight;
        if (other.selectedIcon.hasValue()) selectedIcon = other.selectedIcon;
        if (other.iconColor.hasValue()) iconColor = other.iconColor;
        if (other.selectedIconColor.hasValue()) selectedIconColor = other.selectedIconColor;
        if (other.badge.hasValue()) badge = other.badge;
        if (other.badgeColor.hasValue()) badgeColor = other.badgeColor;
        if (other.animateBadge.hasValue()) animateBadge = other.animateBadge;
        if (other.testId.hasValue()) testId = other.testId;
        if (other.fontSize.hasValue()) fontSize = other.fontSize;
        if (other.selectedFontSize.hasValue()) selectedFontSize = other.selectedFontSize;
        font.mergeWith(other.font);
        if (other.dotIndicator.hasValue()) dotIndicator = other.dotIndicator;
        if (other.selectTabOnPress.hasValue()) selectTabOnPress = other.selectTabOnPress;
    }

    void mergeWithDefault(final BottomTabOptions defaultOptions) {
        if (!text.hasValue()) text = defaultOptions.text;
        if (!textColor.hasValue()) textColor = defaultOptions.textColor;
        if (!selectedTextColor.hasValue()) selectedTextColor = defaultOptions.selectedTextColor;
        if (!icon.hasValue()) icon = defaultOptions.icon;
        if (!iconWidth.hasValue()) iconWidth = defaultOptions.iconWidth;
        if (!iconHeight.hasValue()) iconHeight = defaultOptions.iconHeight;
        if (!selectedIcon.hasValue()) selectedIcon = defaultOptions.selectedIcon;
        if (!iconColor.hasValue()) iconColor = defaultOptions.iconColor;
        if (!selectedIconColor.hasValue()) selectedIconColor = defaultOptions.selectedIconColor;
        if (!badge.hasValue()) badge = defaultOptions.badge;
        if (!badgeColor.hasValue()) badgeColor = defaultOptions.badgeColor;
        if (!animateBadge.hasValue()) animateBadge = defaultOptions.animateBadge;
        if (!fontSize.hasValue()) fontSize = defaultOptions.fontSize;
        if (!selectedFontSize.hasValue()) selectedFontSize = defaultOptions.selectedFontSize;
        font.mergeWithDefault(defaultOptions.font);
        if (!testId.hasValue()) testId = defaultOptions.testId;
        if (!dotIndicator.hasValue()) dotIndicator = defaultOptions.dotIndicator;
        if (!selectTabOnPress.hasValue()) selectTabOnPress = defaultOptions.selectTabOnPress;
    }
}
