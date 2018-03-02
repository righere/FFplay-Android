
LOCAL_PATH := $(call my-dir)


include $(CLEAR_VARS)

LOCAL_MODULE:= avcodec

LOCAL_SRC_FILES:= lib/libavcodec-57.so

LOCAL_EXPORT_C_INCLUDES:= $(LOCAL_PATH)/include

include $(PREBUILT_SHARED_LIBRARY)


include $(CLEAR_VARS)

LOCAL_MODULE:= avformat

LOCAL_SRC_FILES:= lib/libavformat-57.so

LOCAL_EXPORT_C_INCLUDES:= $(LOCAL_PATH)/include

include $(PREBUILT_SHARED_LIBRARY)



include $(CLEAR_VARS)

LOCAL_MODULE:= swscale

LOCAL_SRC_FILES:= lib/libswscale-4.so

LOCAL_EXPORT_C_INCLUDES:= $(LOCAL_PATH)/include

include $(PREBUILT_SHARED_LIBRARY)


include $(CLEAR_VARS)

LOCAL_MODULE:= avutil

LOCAL_SRC_FILES:= lib/libavutil-55.so

LOCAL_EXPORT_C_INCLUDES:= $(LOCAL_PATH)/include

include $(PREBUILT_SHARED_LIBRARY)


include $(CLEAR_VARS)

LOCAL_MODULE:= avfilter

LOCAL_SRC_FILES:= $(LOCAL_PATH)/lib/libavfilter-6.so

LOCAL_EXPORT_C_INCLUDES:= $(LOCAL_PATH)/include

include $(PREBUILT_SHARED_LIBRARY)


include $(CLEAR_VARS)

LOCAL_MODULE:= swresample

LOCAL_SRC_FILES:= lib/libswresample-2.so

LOCAL_EXPORT_C_INCLUDES:= $(LOCAL_PATH)/include

include $(PREBUILT_SHARED_LIBRARY)


include $(CLEAR_VARS)

LOCAL_MODULE:= avdevice

LOCAL_SRC_FILES:= lib/libavdevice-57.so

LOCAL_EXPORT_C_INCLUDES:= $(LOCAL_PATH)/include

include $(PREBUILT_SHARED_LIBRARY)


include $(CLEAR_VARS)

LOCAL_MODULE := ffmpeg

LOCAL_C_INCLUDES := $(LOCAL_PATH)/include

LOCAL_EXPORT_C_INCLUDES := $(LOCAL_C_INCLUDES)

LOCAL_SHARED_LIBRARIES := avcodec avfilter avformat avutil  swresample swscale avdevice

include $(BUILD_SHARED_LIBRARY)

