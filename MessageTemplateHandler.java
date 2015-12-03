/*********************************************************************
 Copyright (c) 2015 Cloud Dynamics Inc. All rights reserved.
 Cloud Dynamics grants you a non-exclusive, non-transferable license (without the right to sublicense) to use
 and modify this software. Reproduction, distribution, or other exploitation of these files is strictly prohibited.
 As a condition to the foregoing grant, you must not remove, alter, or obscure this notice.
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *********************************************************************/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clouddynamics.heliotime.helper;


import com.clouddynamics.heliotime.exception.HeliotimeException;
import com.clouddynamics.heliotime.external.system.helper.ConfigurationController;
import com.clouddynamics.heliotime.type.ConfigurationNameType;
import com.clouddynamics.heliotime.api.usage.meta.UsageNotifyMeta;

/**
 * @author kam
 */
public class MessageTemplateHandler {

  private static void buildFooter(StringBuilder s) throws HeliotimeException {
    s.append("\n\n");
    s.append("-------------------------------------- ");
    s.append("\n");
    s.append(ConfigurationController.getInstance().getConfiguration(ConfigurationNameType.EMAIL_SIGNATURE).getValue());

  }

  public static String getUsageNotificationTemplate(UsageNotifyMeta meta) throws HeliotimeException {
    StringBuilder s = new StringBuilder();
    s.append("Dear ").append(meta.getFirstName()).append(" ").append(meta.getLastName()).append(",");
    s.append("\n");
    s.append("\n");
    s.append("Your latest usage report for - usagePeriod - is not available online:"); 
    s.append("\n");
    s.append("\n");
    s.append("Account Name: " + " ");              
    s.append("\n");             
    s.append("Account Number: ending in " + StringUtil.showOnlyLast(meta.getAccountNumber(), 4, '*')); 
    s.append("\n");
    s.append("\n");             
    s.append("Please login at https://console.1nc.sg to view your usage report."); 
    s.append("\n");
    s.append("\n");             
    s.append("Thank you for using 1-Net Alchemy and we look forward to serve you better."); 
    s.append("\n");
    s.append("\n");             
    s.append("***This is an automatically generated notification, please do not reply to this email.***");         
//    s.append("Please login at").append(ConfigurationController.getInstance().getConfiguration(ConfigurationNameType.DEFAULT_C3_LOGIN_URL).getValue());
    
    return s.toString();
  }

  public static String getUsageNotifySubjectTemplate(String usagePeriod) throws HeliotimeException {
    return ConfigurationController.getInstance().getConfiguration(ConfigurationNameType.EMAIL_SUBJECT).getValue() + " Usage Statement For " + usagePeriod;
  }

}
