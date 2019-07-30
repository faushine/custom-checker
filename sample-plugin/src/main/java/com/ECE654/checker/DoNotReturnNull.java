package com.ECE654.checker;

import static com.google.errorprone.BugPattern.LinkType.CUSTOM;
import static com.google.errorprone.BugPattern.SeverityLevel.ERROR;
import static com.google.errorprone.BugPattern.SeverityLevel.SUGGESTION;
import static com.google.errorprone.BugPattern.SeverityLevel.WARNING;
import static com.google.errorprone.matchers.Matchers.contains;
import static com.google.errorprone.matchers.Matchers.hasAnnotation;
import static com.sun.source.tree.Tree.Kind.NULL_LITERAL;

import com.google.auto.service.AutoService;
import com.google.errorprone.BugPattern;
import com.google.errorprone.VisitorState;
import com.google.errorprone.bugpatterns.BugChecker;
import com.google.errorprone.bugpatterns.BugChecker.MethodTreeMatcher;
import com.google.errorprone.matchers.Description;
import com.google.errorprone.matchers.Matcher;
import com.google.errorprone.matchers.Matchers;

import com.sun.source.tree.MethodTree;
import com.sun.source.tree.ReturnTree;
import com.sun.source.tree.Tree;

import javax.annotation.Nullable;


/**
 * Bug checker to detect usage of {@code return null;}.
 */
@AutoService(BugChecker.class)
@BugPattern(
    name = "DoNotReturnNull",
    summary = "Do not return null.",
    linkType = BugPattern.LinkType.CUSTOM,
    link = "https://www.infoq.com/presentations/Null-References-The-Billion-Dollar-Mistake-Tony-Hoare",
    severity = ERROR)
public class DoNotReturnNull extends BugChecker implements BugChecker.MethodTreeMatcher {

  private static final Matcher<Tree> HAS_NULLABLE_ANNOTATION = hasAnnotation(Nullable.class.getName());
  private static final Matcher<Tree> CONTAINS_RETURN_NULL = contains(new ReturnNullMatcher());

  @Override
  public Description matchMethod(MethodTree tree, VisitorState state) {
    if(!HAS_NULLABLE_ANNOTATION.matches(tree, state) && CONTAINS_RETURN_NULL.matches(tree, state)){
      return describeMatch(tree);
    }

    return Description.NO_MATCH;
  }

  private static class ReturnNullMatcher implements Matcher<Tree> {
    @Override
    public boolean matches(Tree tree, VisitorState state) {
      if(tree instanceof ReturnTree){
        return ((ReturnTree) tree).getExpression().getKind() == NULL_LITERAL;
      }
      return false;

    }
  }
}
