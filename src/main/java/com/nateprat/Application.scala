package com.nateprat

import java.io.File
import java.util.StringJoiner

import com.nateprat.core.algorithm.AlgorithmFactory
import com.nateprat.core.data.{FileReader, RouteMapToCsvTranslator, WriteToFile}
import com.nateprat.core.extractor.RouteExtractor
import com.nateprat.core.interactive.CustomRoute
import com.nateprat.core.transformer.DefaultTransformer
import com.nateprat.model.{Report, Route, RouteMap}
import com.nateprat.system.user.Menu


object Application extends App {
  Menu.mainMenu()
}
