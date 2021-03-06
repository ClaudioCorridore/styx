/*
  Copyright (C) 2013-2018 Expedia Inc.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package com.hotels.styx.api.support;

import com.hotels.styx.api.HttpCookie;

import java.util.Collection;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * Does some validation for cookie header names.
 */
public final class CookiesSupport {
    private CookiesSupport() {
    }

    /**
     * Determine whether a header is a cookie header, i.e. server cookie ("Set-Cookie") or client cookie ("Cookie")
     *
     * @param header header name
     * @return if the header is a cookie header
     */
    public static boolean isCookieHeader(String header) {
        return "Set-Cookie".equalsIgnoreCase(header) || "Cookie".equalsIgnoreCase(header);
    }

    /**
     * Find a cookie with the specified {@code name}.
     *
     * @param cookies list of cookies
     * @param name cookie name
     * @return the cookie if present
     */
    public static Optional<HttpCookie> findCookie(Collection<HttpCookie> cookies, String name){
        requireNonNull(cookies);
        requireNonNull(name);
        return cookies
                .stream()
                .filter(cookie -> name.equals(cookie.name()))
                .findFirst();
    }
}
