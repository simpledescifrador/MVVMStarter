package com.esys.mvvmstarter.utils.threads;


import java.util.Collections;
import timber.log.Timber;

/**
 * A simple async task with return value.
 *
 * The RThreader (Return Threader) is an AsyncTask which can return a variety of data types base on the return type.
 * This lessen the coding time, for the developer as it can be called using its methods without creating another set
 * of
 * AsyncTask Class.
 */
public class RThreader {

    /**
     * rlThreader - (Return List Threader) this method only accepts list return data types.
     *
     * @param irThreader (Interface Return Threader) callback, runs asynchronously.
     * @return generic type List<?>, accepts any return data type except T.
     */
    public static <T, C extends Collections> T rlThreader(final IRThreader irThreader) {

        try {
            return (T) new RLThreader(irThreader).execute().get();
        } catch (Exception ex) {
            Timber.e(ex);
            return null;
        }
    }

    /**
     * rsThreader - (Return Single Threader) this method only accepts objects, integer, string, or any data type that
     * doesn't use
     * List<>.
     *
     * @param irThreader (Interface Return Threader) callback, runs asynchronously.
     * @return generic type T, accepts any return data type except List<?>.
     */
    public static <T, C extends Collections> T rsThreader(final IRThreader irThreader) {

        try {
            return (T) new RSThreader(irThreader).execute().get();
        } catch (Exception ex) {
            Timber.e(ex);
            return null;
        }
    }
}
