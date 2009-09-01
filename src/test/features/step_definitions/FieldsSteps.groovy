import cuke4duke.Table

this.metaClass.mixin(cuke4duke.GroovyDsl)

Given(~/the following fields are in the database/) {Table table ->
  world.clearTable("fields");
  world.populateTable("fields", table.hashes());
}

When(~/an api user requests a field list in \"(.*)\" format/) {String format ->
  world.get("fields", format);
}
