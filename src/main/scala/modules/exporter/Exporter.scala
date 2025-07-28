package modules.exporter

trait Exporter [T]{
  def doExport(input : T) : Unit
}
