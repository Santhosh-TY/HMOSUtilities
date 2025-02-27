/*
 * Copyright 2016 Matthew Tamlin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.matthewtamlin.android_utilities.library.helpers;


import ohos.app.Context;
import ohos.media.audio.AudioInterrupt;
import ohos.media.audio.AudioManager;

import static com.matthewtamlin.java_utilities.checkers.NullChecker.checkNotNull;

/**
 * Obtains and abandons audio focus.
 */
public class AudioFocusHelper {
	/**
	 * Requests stream alarm audio-focus for the supplied listener.
	 *
	 * @param context
	 * 		the Context in which {@code listener} is operating, not null
	 * @param listener
	 * 		the OnAudioFocusChangeListener to receive the audio focus, not null
	 *
	 * @return true if audio focus is granted, false otherwise
	 *
	 * @throws IllegalArgumentException
	 * 		if {@code context} is null
	 * @throws IllegalArgumentException
	 * 		if {@code listener} is null
	 */
	public static boolean requestStreamAlarmFocus(
			final Context context,
			final AudioInterrupt.InterruptListener listener) {

		return requestStreamAudioFocus(context, listener, AudioManager.AudioVolumeType.STREAM_ALARM);
	}

	/**
	 * Requests stream DTMF audio-focus for the supplied listener.
	 *
	 * @param context
	 * 		the Context in which {@code listener} is operating, not null
	 * @param listener
	 * 		the OnAudioFocusChangeListener to receive the audio focus, not null
	 *
	 * @return true if audio focus is granted, false otherwise
	 *
	 * @throws IllegalArgumentException
	 * 		if {@code context} is null
	 * @throws IllegalArgumentException
	 * 		if {@code listener} is null
	 */
	public static boolean requestStreamDtmfFocus(
			final Context context,
			final AudioInterrupt.InterruptListener listener) {

		return requestStreamAudioFocus(context, listener, AudioManager.AudioVolumeType.STREAM_DTMF);
	}

	/**
	 * Requests stream notification audio-focus for the supplied listener.
	 *
	 * @param context
	 * 		the Context in which {@code listener} is operating, not null
	 * @param listener
	 * 		the OnAudioFocusChangeListener to receive the audio focus, not null
	 *
	 * @return true if audio focus is granted, false otherwise
	 *
	 * @throws IllegalArgumentException
	 * 		if {@code context} is null
	 * @throws IllegalArgumentException
	 * 		if {@code listener} is null
	 */
	public static boolean requestStreamNotificationFocus(
			final Context context,
			final AudioInterrupt.InterruptListener listener) {

		return requestStreamAudioFocus(context, listener, AudioManager.AudioVolumeType.STREAM_NOTIFICATION);
	}

	/**
	 * Requests stream music audio-focus for the supplied listener.
	 *
	 * @param context
	 * 		the Context in which {@code listener} is operating, not null
	 * @param listener
	 * 		the OnAudioFocusChangeListener to receive the audio focus, not null
	 *
	 * @return true if audio focus is granted, false otherwise
	 *
	 * @throws IllegalArgumentException
	 * 		if {@code context} is null
	 * @throws IllegalArgumentException
	 * 		if {@code listener} is null
	 */
	public static boolean requestStreamMusicFocus(
			final Context context,
			final AudioInterrupt.InterruptListener listener) {

		return requestStreamAudioFocus(context, listener, AudioManager.AudioVolumeType.STREAM_MUSIC);
	}

	/**
	 * Requests stream ring audio-focus for the supplied listener.
	 *
	 * @param context
	 * 		the Context in which {@code listener} is operating, not null
	 * @param listener
	 * 		the OnAudioFocusChangeListener to receive the audio focus, not null
	 *
	 * @return true if audio focus is granted, false otherwise
	 *
	 * @throws IllegalArgumentException
	 * 		if {@code context} is null
	 * @throws IllegalArgumentException
	 * 		if {@code listener} is null
	 */
	public static boolean requestStreamRingFocus(
			final Context context,
			final AudioInterrupt.InterruptListener listener) {

		return requestStreamAudioFocus(context, listener, AudioManager.AudioVolumeType.STREAM_RING);
	}

	/**
	 * Requests stream system audio-focus for the supplied listener.
	 *
	 * @param context
	 * 		the Context in which {@code listener} is operating, not null
	 * @param listener
	 * 		the OnAudioFocusChangeListener to receive the audio focus, not null
	 *
	 * @return true if audio focus is granted, false otherwise
	 *
	 * @throws IllegalArgumentException
	 * 		if {@code context} is null
	 * @throws IllegalArgumentException
	 * 		if {@code listener} is null
	 */
	public static boolean requestStreamSystemFocus(
			final Context context,
			final AudioInterrupt.InterruptListener listener) {

		return requestStreamAudioFocus(context, listener, AudioManager.AudioVolumeType.STREAM_SYSTEM);
	}

	/**
	 * Requests stream voice call audio-focus for the supplied listener.
	 *
	 * @param context
	 * 		the Context in which {@code listener} is operating, not null
	 * @param listener
	 * 		the OnAudioFocusChangeListener to receive the audio focus, not null
	 *
	 * @return true if audio focus is granted, false otherwise
	 *
	 * @throws IllegalArgumentException
	 * 		if {@code context} is null
	 * @throws IllegalArgumentException
	 * 		if {@code listener} is null
	 */
	public static boolean requestStreamVoiceCallFocus(
			final Context context,
			final AudioInterrupt.InterruptListener listener) {

		return requestStreamAudioFocus(context, listener,AudioManager.AudioVolumeType.STREAM_VOICE_CALL);
	}

	/**
	 * Abandons audio focus.
	 *
	 * @param context
	 * 		the Context in which {@code listener} is operating, not null
	 * @param listener
	 * 		the OnAudioFocusChangeListener which will lose audio focus, not null
	 *
	 * @throws IllegalArgumentException
	 * 		if {@code context} is null
	 * @throws IllegalArgumentException
	 * 		if {@code listener} is null
	 */
	public static void abandonFocus(
			final Context context,
			final AudioInterrupt.InterruptListener listener) {

		checkNotNull(context, "context cannot be null");
		checkNotNull(listener, "listener cannot be null");

		final AudioManager am = (AudioManager) context.getAbilityPackageContext();
		am.deactivateAudioInterrupt((AudioInterrupt) listener);
	}

	/**
	 * Requests a particular type of audio focus for the supplied listener.
	 *
	 * @param context
	 * 		the Context in which {@code listener} is operating, not null
	 * @param listener
	 * 		the OnAudioFocusChangeListener to receive the audio focus, not null
	 * @param streamType
	 * 		the type of stream to request (see static fields of AudioManager)
	 *.
	 * @return true if focus was granted, false otherwise
	 *
	 * @throws IllegalArgumentException
	 * 		if {@code context} is null
	 * @throws IllegalArgumentException
	 * 		if {@code listener} is null
	 */
	private static boolean requestStreamAudioFocus(
			final Context context,
			final AudioInterrupt.InterruptListener listener,
			final AudioManager.AudioVolumeType streamType) {

		checkNotNull(context, "context cannot be null");
		checkNotNull(listener, "listener cannot be null");

		final AudioManager am = (AudioManager) context.getAbilityPackageContext();
		 int result=0;
		try {
			 result = am.getVolume(streamType);
		}
		catch(Exception ec){
			ec.printStackTrace();
		}
		return result == AudioManager.RINGER_MODE_MAX;
	}
}