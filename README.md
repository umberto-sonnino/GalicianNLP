# GalicianNLP
The repository for the Galician part of the NLP First Homework

The overall objective of this homework is to create a multilingual morphological parser based on Wiktionary. Each team (one or two students) will work on the assigned language(s) . The team’s objective is to deliver Java code to extract a full morphological table for the assigned language(s) together with the table itself . The information has to be extracted from the Wiktionary dump of the given language and/or the English Wiktionary dump which contains information for all languages.
What has been implemented
The minimum classes to be implemented are:
– An extension of our MorphoEntryIterator called <Lang>MorphoEntryIterator which iterates over the entries in the language-specific raw dump and/or the English (multilingual) dump, where <Lang> is your language
– A class for each morphological rule, as implementation of MorphoRule, for the given language. Naming convention: <Lang>MorphoRule<RuleName>

Optionally, you can create <Lang>MorphoForm, your extension of MorphoForm should you need to save more information . For instance, you will deliver:
– it/uniroma1/lcl/wimmp/FrenchMorphoEntryIterator.java
– it/uniroma1/lcl/wimmp/FrenchMorphoRules.java
– it/uniroma1/lcl/wimmp/FrenchMorphoForm.java
– it/uniroma1/lcl/wimmp/FrenchMorphoEntryIterator.class
– it/uniroma1/lcl/wimmp/FrenchMorphoRules.class
– it/uniroma1/lcl/wimmp/FrenchMorphoForm.class
