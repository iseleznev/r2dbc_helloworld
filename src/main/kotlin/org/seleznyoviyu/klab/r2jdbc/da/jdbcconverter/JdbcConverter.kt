package org.seleznyoviyu.klab.r2jdbc.da.jdbcconverter

import org.springframework.core.convert.converter.Converter

interface JdbcConverter<TSource, TTarget> : Converter<TSource, TTarget>