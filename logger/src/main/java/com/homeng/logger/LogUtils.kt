package com.homeng.logger

import android.util.Log

public class LogUtils {
    companion object {
        /**
         * Priority constant for the println method; use Log.v.
         */
        //const val VERBOSE = 2

        /**
         * Priority constant for the println method; use Log.d.
         */
        //const val DEBUG = 3

        /**
         * Priority constant for the println method; use Log.i.
         */
        //const val INFO = 4

        /**
         * Priority constant for the println method; use Log.w.
         */
        //const val WARN = 5

        /**
         * Priority constant for the println method; use Log.e.
         */
        const val ERROR = 6

        /**
         * Priority constant for the println method.
         */
        //const val ASSERT = 7

        /**
         * Send a [.VERBOSE] log message.
         * @param tag Used to identify the source of a log message.  It usually identifies
         * the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         */
        fun v(tag: String?, msg: String): Int {
            return Log.v(tag, msg)
        }

        /**
         * Send a [.VERBOSE] log message and log the exception.
         * @param tag Used to identify the source of a log message.  It usually identifies
         * the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         * @param tr An exception to log
         */
        fun v(tag: String?, msg: String, tr: Throwable?): Int {
            return Log.v(tag, msg, tr)
        }

        /**
         * Send a [.DEBUG] log message.
         * @param tag Used to identify the source of a log message.  It usually identifies
         * the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         */
        fun d(tag: String?, msg: String): Int {
            return Log.d(tag, msg)
        }

        /**
         * Send a [.DEBUG] log message and log the exception.
         * @param tag Used to identify the source of a log message.  It usually identifies
         * the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         * @param tr An exception to log
         */
        fun d(tag: String?, msg: String, tr: Throwable?): Int {
            return Log.d(tag, msg, tr)
        }

        /**
         * Send an [.INFO] log message.
         * @param tag Used to identify the source of a log message.  It usually identifies
         * the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         */
        fun i(tag: String?, msg: String): Int {
            return Log.i(tag, msg)
        }

        /**
         * Send a [.INFO] log message and log the exception.
         * @param tag Used to identify the source of a log message.  It usually identifies
         * the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         * @param tr An exception to log
         */
        fun i(tag: String?, msg: String, tr: Throwable?): Int {
            return Log.i(tag, msg, tr)
        }

        /**
         * Send a [.WARN] log message.
         * @param tag Used to identify the source of a log message.  It usually identifies
         * the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         */
        fun w(tag: String?, msg: String): Int {
            return Log.w(tag, msg)
        }

        /**
         * Send a [.WARN] log message and log the exception.
         * @param tag Used to identify the source of a log message.  It usually identifies
         * the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         * @param tr An exception to log
         */
        fun w(tag: String?, msg: String, tr: Throwable?): Int {
            return Log.w(tag, msg, tr)
        }

        /**
         * Send a {@link #WARN} log message and log the exception.
         * @param tag Used to identify the source of a log message.  It usually identifies
         *        the class or activity where the log call occurs.
         * @param tr An exception to log
         */
        fun w(tag: String?, tr: Throwable?): Int {
            return Log.w(tag, tr)
        }

        /**
         * Send an [.ERROR] log message.
         * @param tag Used to identify the source of a log message.  It usually identifies
         * the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         */
        fun e(tag: String?, msg: String): Int {
            return Log.e(tag, msg)
        }

        /**
         * Send a [.ERROR] log message and log the exception.
         * @param tag Used to identify the source of a log message.  It usually identifies
         * the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         * @param tr An exception to log
         */
        fun e(tag: String?, msg: String, tr: Throwable?): Int {
            return Log.e(tag, msg, tr)
        }

        /**
         * Handy function to get a loggable stack trace from a Throwable
         * @param tr An exception to log
         */
        fun getStackTraceString(tr: Throwable?): String {
            return Log.getStackTraceString(tr)
        }

        /**
         * Low-level logging call.
         * @param priority The priority/type of this log message
         * @param tag Used to identify the source of a log message.  It usually identifies
         * the class or activity where the log call occurs.
         * @param msg The message you would like logged.
         * @return The number of bytes written.
         */
        fun println(priority: Int, tag: String?, msg: String): Int {
            return Log.println(priority, tag, msg)
        }

    }
}