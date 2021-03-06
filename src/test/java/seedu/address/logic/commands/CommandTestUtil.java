package seedu.address.logic.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEDUCTIBLES;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEPARTMENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MANAGER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_OTHOUR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_OTRATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRIVATE_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRIVATE_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRIVATE_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SALARY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.testutil.EditPersonDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "91231234";
    public static final String VALID_PHONE_BOB = "81231234";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_DEPARTMENT_AMY = "Accounting";
    public static final String VALID_DEPARTMENT_BOB = "Marketing";
    public static final String VALID_MANAGER_AMY = "Ben Leong";
    public static final String VALID_MANAGER_BOB = "Marcus Tan";
    public static final String VALID_SALARY_AMY = "2000";
    public static final String VALID_SALARY_BOB = "1000";
    public static final String VALID_OTHOUR_AMY = "20";
    public static final String VALID_OTHOUR_BOB = "10";
    public static final String VALID_OTRATE_AMY = "20";
    public static final String VALID_OTRATE_BOB = "10";
    public static final String VALID_DEDUCTIBLES_AMY = "200";
    public static final String VALID_DEDUCTIBLES_BOB = "100";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    //    public static final String PRIVATE_PHONE_DESC_AMY = " " + PREFIX_PRIVATE_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String PRIVATE_PHONE_DESC_BOB = " " + PREFIX_PRIVATE_PHONE + VALID_PHONE_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    //    public static final String PRIVATE_EMAIL_DESC_AMY = " " + PREFIX_PRIVATE_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String PRIVATE_EMAIL_DESC_BOB = " " + PREFIX_PRIVATE_EMAIL + VALID_EMAIL_BOB;
    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    //    public static final String PRIVATE_ADDRESS_DESC_AMY = " " + PREFIX_PRIVATE_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;
    public static final String PRIVATE_ADDRESS_DESC_BOB = " " + PREFIX_PRIVATE_ADDRESS + VALID_ADDRESS_BOB;
    public static final String DEPARTMENT_DESC_AMY = " " + PREFIX_DEPARTMENT + VALID_DEPARTMENT_AMY;
    public static final String DEPARTMENT_DESC_BOB = " " + PREFIX_DEPARTMENT + VALID_DEPARTMENT_BOB;
    public static final String MANAGER_DESC_AMY = " " + PREFIX_MANAGER + VALID_MANAGER_AMY;
    public static final String MANAGER_DESC_BOB = " " + PREFIX_MANAGER + VALID_MANAGER_BOB;
    public static final String SALARY_DESC_AMY = " " + PREFIX_SALARY + VALID_SALARY_AMY;
    public static final String SALARY_DESC_BOB = " " + PREFIX_SALARY + VALID_SALARY_BOB;
    public static final String OTHOUR_DESC_AMY = " " + PREFIX_OTHOUR + VALID_OTHOUR_AMY;
    public static final String OTHOUR_DESC_BOB = " " + PREFIX_OTHOUR + VALID_OTHOUR_BOB;
    public static final String OTRATE_DESC_AMY = " " + PREFIX_OTRATE + VALID_OTRATE_AMY;
    public static final String OTRATE_DESC_BOB = " " + PREFIX_OTRATE + VALID_OTRATE_BOB;
    public static final String DEDUCTIBLES_DESC_AMY = " " + PREFIX_DEDUCTIBLES + VALID_DEDUCTIBLES_AMY;
    public static final String DEDUCTIBLES_DESC_BOB = " " + PREFIX_DEDUCTIBLES + VALID_DEDUCTIBLES_BOB;
    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_DEPARTMENT_DESC = " " + PREFIX_DEPARTMENT + "Accounting123"; // '123' not allowed
    public static final String INVALID_MANAGER_DESC = " " + PREFIX_MANAGER + "B@N"; // '@' not allowed in names
    public static final String INVALID_SALARY_DESC = " " + PREFIX_SALARY + "$2000"; // '$' not allowed in salary
    public static final String INVALID_OTHOUR_DESC = " " + PREFIX_OTHOUR + "25hrs"; // letters not allowed in hours
    public static final String INVALID_OTRATE_DESC = " " + PREFIX_OTRATE + "20/hr"; // letters not allowed in rate
    public static final String INVALID_DEDUCTIBLES_DESC = " " + PREFIX_DEDUCTIBLES
        + "$1000"; // '$' not allowed in deductibles
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditPersonDescriptor DESC_AMY;
    public static final EditCommand.EditPersonDescriptor DESC_BOB;

    static {
        DESC_AMY = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
                .withDepartment(VALID_DEPARTMENT_AMY).withManager(VALID_MANAGER_AMY)
                .withSalary(VALID_SALARY_AMY).withHour(VALID_OTHOUR_AMY)
                .withRate(VALID_OTRATE_AMY).withDeductibles(VALID_DEDUCTIBLES_AMY)
                .withTags(VALID_TAG_FRIEND).build();
        DESC_BOB = new EditPersonDescriptorBuilder().withName(VALID_NAME_BOB)
                .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
                .withDepartment(VALID_DEPARTMENT_BOB).withManager(VALID_MANAGER_BOB)
                .withSalary(VALID_SALARY_BOB).withHour(VALID_OTHOUR_BOB)
                .withRate(VALID_OTRATE_BOB).withDeductibles(VALID_DEDUCTIBLES_BOB)
                .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the result message matches {@code expectedMessage} <br>
     * - the {@code actualModel} matches {@code expectedModel} <br>
     * - the {@code actualCommandHistory} remains unchanged.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandHistory actualCommandHistory,
            String expectedMessage, Model expectedModel) {
        CommandHistory expectedCommandHistory = new CommandHistory(actualCommandHistory);
        try {
            CommandResult result = command.execute(actualModel, actualCommandHistory);
            assertEquals(expectedMessage, result.feedbackToUser);
            assertEquals(expectedModel, actualModel);
            assertEquals(expectedCommandHistory, actualCommandHistory);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book and the filtered person list in the {@code actualModel} remain unchanged <br>
     * - {@code actualCommandHistory} remains unchanged.
     */
    public static void assertCommandFailure(Command command, Model actualModel, CommandHistory actualCommandHistory,
            String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Person> expectedFilteredList = new ArrayList<>(actualModel.getFilteredPersonList());

        CommandHistory expectedCommandHistory = new CommandHistory(actualCommandHistory);

        try {
            command.execute(actualModel, actualCommandHistory);
            throw new AssertionError("The expected CommandException was not thrown.");
        } catch (CommandException e) {
            assertEquals(expectedMessage, e.getMessage());
            assertEquals(expectedAddressBook, actualModel.getAddressBook());
            assertEquals(expectedFilteredList, actualModel.getFilteredPersonList());
            assertEquals(expectedCommandHistory, actualCommandHistory);
        }
    }

    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPersonList().size());

        Person person = model.getFilteredPersonList().get(targetIndex.getZeroBased());
        final String[] splitName = person.getName().fullName.split("\\s+");
        model.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredPersonList().size());
    }

    /**
     * Deletes the first person in {@code model}'s filtered list from {@code model}'s address book.
     */
    public static void deleteFirstPerson(Model model) {
        Person firstPerson = model.getFilteredPersonList().get(0);
        model.deletePerson(firstPerson);
        model.commitAddressBook();
    }

}
