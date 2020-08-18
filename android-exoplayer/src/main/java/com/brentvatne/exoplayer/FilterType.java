package com.brentvatne.exoplayer;

import android.content.Context;
import android.util.Log;

import com.daasuu.epf.filter.GlBilateralFilter;
import com.daasuu.epf.filter.GlBoxBlurFilter;
import com.daasuu.epf.filter.GlBrightnessFilter;
import com.daasuu.epf.filter.GlBulgeDistortionFilter;
import com.daasuu.epf.filter.GlCGAColorspaceFilter;
import com.daasuu.epf.filter.GlContrastFilter;
import com.daasuu.epf.filter.GlCrosshatchFilter;
import com.daasuu.epf.filter.GlExposureFilter;
import com.daasuu.epf.filter.GlFilter;
import com.daasuu.epf.filter.GlFilterGroup;
import com.daasuu.epf.filter.GlGammaFilter;
import com.daasuu.epf.filter.GlGaussianBlurFilter;
import com.daasuu.epf.filter.GlGrayScaleFilter;
import com.daasuu.epf.filter.GlHalftoneFilter;
import com.daasuu.epf.filter.GlHazeFilter;
import com.daasuu.epf.filter.GlHighlightShadowFilter;
import com.daasuu.epf.filter.GlHueFilter;
import com.daasuu.epf.filter.GlInvertFilter;
import com.daasuu.epf.filter.GlLuminanceFilter;
import com.daasuu.epf.filter.GlLuminanceThresholdFilter;
import com.daasuu.epf.filter.GlMonochromeFilter;
import com.daasuu.epf.filter.GlOpacityFilter;
import com.daasuu.epf.filter.GlPixelationFilter;
import com.daasuu.epf.filter.GlPosterizeFilter;
import com.daasuu.epf.filter.GlRGBFilter;
import com.daasuu.epf.filter.GlSaturationFilter;
import com.daasuu.epf.filter.GlSepiaFilter;
import com.daasuu.epf.filter.GlSharpenFilter;
import com.daasuu.epf.filter.GlSolarizeFilter;
import com.daasuu.epf.filter.GlSphereRefractionFilter;
import com.daasuu.epf.filter.GlSwirlFilter;
import com.daasuu.epf.filter.GlToneCurveFilter;
import com.daasuu.epf.filter.GlToneFilter;
import com.daasuu.epf.filter.GlVibranceFilter;
import com.daasuu.epf.filter.GlVignetteFilter;
import com.daasuu.epf.filter.GlWeakPixelInclusionFilter;
import com.daasuu.epf.filter.GlWhiteBalanceFilter;
import com.daasuu.epf.filter.GlZoomBlurFilter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sudamasayuki on 2017/05/18.
 */

public enum FilterType {
    DEFAULT,
    BITMAP_OVERLAY_SAMPLE,
    BILATERAL_BLUR,
    BOX_BLUR,
    BRIGHTNESS,
    BULGE_DISTORTION,
    CGA_COLORSPACE,
    CONTRAST,
    CROSSHATCH,
    EXPOSURE,
    FILTER_GROUP_SAMPLE,
    GAMMA,
    GAUSSIAN_FILTER,
    GRAY_SCALE,
    HAZE,
    HALFTONE,
    HIGHLIGHT_SHADOW,
    HUE,
    INVERT,
    LUMINANCE,
    LUMINANCE_THRESHOLD,
    MONOCHROME,
    OPACITY,
    OVERLAY,
    PIXELATION,
    POSTERIZE,
    RGB,
    SATURATION,
    SEPIA,
    SHARP,
    SOLARIZE,
    SPHERE_REFRACTION,
    SWIRL,
    TONE_CURVE_SAMPLE,
    TONE,
    VIBRANCE,
    VIGNETTE,
    WATERMARK,
    WEAK_PIXEL,
    WHITE_BALANCE,
    ZOOM_BLUR,
    ;


    public static List<FilterType> createFilterList() {
        return Arrays.asList(FilterType.values());
    }


    public static GlFilter createGlFilter(String filterType, String index, Context context) {
        switch (filterType) {
            case "DEFAULT":
                return new GlFilter();
            case "BILATERAL_BLUR":
                return new GlBilateralFilter();
            case "BOX_BLUR":
                return new GlBoxBlurFilter();
            case "BRIGHTNESS":
                GlBrightnessFilter glBrightnessFilter = new GlBrightnessFilter();
                glBrightnessFilter.setBrightness(0.2f);
                return glBrightnessFilter;
            case "BULGE_DISTORTION":
                return new GlBulgeDistortionFilter();
            case "CGA_COLORSPACE":
                return new GlCGAColorspaceFilter();
            case "CONTRAST":
                GlContrastFilter glContrastFilter = new GlContrastFilter();
                String[] listIndexContrast = index.split(",");
                glContrastFilter.setContrast(Float.parseFloat(listIndexContrast[0]));
                return glContrastFilter;
            case "CROSSHATCH":
                return new GlCrosshatchFilter();
            case "EXPOSURE":
                return new GlExposureFilter();
            case "FILTER_GROUP_SAMPLE":
                return new GlFilterGroup(new GlSepiaFilter(), new GlVignetteFilter());
            case "GAMMA":
                GlGammaFilter glGammaFilter = new GlGammaFilter();
                glGammaFilter.setGamma(2f);
                return glGammaFilter;
            case "GAUSSIAN_FILTER":
                return new GlGaussianBlurFilter();
            case "GRAY_SCALE":
                return new GlGrayScaleFilter();
            case "HALFTONE":
                return new GlHalftoneFilter();
            case "HAZE":
                GlHazeFilter glHazeFilter = new GlHazeFilter();
                glHazeFilter.setSlope(-0.5f);
                return glHazeFilter;
            case "HIGHLIGHT_SHADOW":
                return new GlHighlightShadowFilter();
            case "HUE":
                return new GlHueFilter();
            case "INVERT":
                return new GlInvertFilter();
            case "LUMINANCE":
                return new GlLuminanceFilter();
            case "LUMINANCE_THRESHOLD":
                return new GlLuminanceThresholdFilter();
            case "MONOCHROME":
                return new GlMonochromeFilter();
            case "OPACITY":
                return new GlOpacityFilter();
            case "PIXELATION":
                return new GlPixelationFilter();
            case "POSTERIZE":
                return new GlPosterizeFilter();
            case "RGB":
                GlRGBFilter glRGBFilter = new GlRGBFilter();
                String[] listIndexColor = index.split(",");
                if (!listIndexColor[0].isEmpty()){
                    glRGBFilter.setRed(Float.parseFloat(listIndexColor[0]));
                }
                if (!listIndexColor[1].isEmpty()){
                    glRGBFilter.setGreen(Float.parseFloat(listIndexColor[1]));
                }
                if (!listIndexColor[2].isEmpty()){
                    glRGBFilter.setBlue(Float.parseFloat(listIndexColor[2]));
                }
                return glRGBFilter;
            case "SATURATION":
                return new GlSaturationFilter();
            case "SEPIA":
                return new GlSepiaFilter();
            case "SHARP":
                GlSharpenFilter glSharpenFilter = new GlSharpenFilter();
                glSharpenFilter.setSharpness(4f);
                return glSharpenFilter;
            case "SOLARIZE":
                return new GlSolarizeFilter();
            case "SPHERE_REFRACTION":
                return new GlSphereRefractionFilter();
            case "SWIRL":
                return new GlSwirlFilter();
            case "TONE_CURVE_SAMPLE":
                try {
                    InputStream is = context.getAssets().open("acv/tone_cuver_sample.acv");
                    return new GlToneCurveFilter(is);
                } catch (IOException e) {
                    Log.e("FilterType", "Error");
                }
                return new GlFilter();
            case "TONE":
                return new GlToneFilter();
            case "VIBRANCE":
                GlVibranceFilter glVibranceFilter = new GlVibranceFilter();
                glVibranceFilter.setVibrance(3f);
                return glVibranceFilter;
            case "VIGNETTE":
                return new GlVignetteFilter();
            case "WEAK_PIXEL":
                return new GlWeakPixelInclusionFilter();
            case "WHITE_BALANCE":
                GlWhiteBalanceFilter glWhiteBalanceFilter = new GlWhiteBalanceFilter();
                glWhiteBalanceFilter.setTemperature(2400f);
                glWhiteBalanceFilter.setTint(2f);
                return glWhiteBalanceFilter;
            case "ZOOM_BLUR":
                return new GlZoomBlurFilter();
            default:
                return new GlFilter();
        }
    }


}

